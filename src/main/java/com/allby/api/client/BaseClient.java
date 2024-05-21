package com.allby.api.client;

import com.allby.api.client.contract.request.LoginRequest;
import com.allby.api.client.contract.response.LoginResponse;
import com.allby.api.client.contract.utils.DesUtils;
import com.allby.api.client.contract.utils.Md5Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public abstract class BaseClient {
    private final Map<String, String> headers = Maps.newConcurrentMap();
    private CloseableHttpClient client;
    private static final String BASE_URL = "http://k8s.allbymusic.com/api";
    private int retry = 1;
    private int connectTimeout = 10 * 1000;
    private int socketTimout = 10 * 1000;
    private int requestTimout = 10 * 1000;
    private String appid;
    private String secret;
    private ObjectMapper objectMapper = new ObjectMapper();
    private long tokenUpdateTime = 0L;
    private String token = null;

    protected BaseClient(String appid, String secret, boolean timerController) {
        this.appid = appid;
        this.secret = secret;
        this.client = createClient();
        this.token = createToken(this.appid, this.secret);
        this.tokenUpdateTime = System.currentTimeMillis();
    }

    private CloseableHttpClient createClient() {
        return HttpClientBuilder.create().build();
    }

    public String createToken(String appid, String secret) {
        if (StringUtils.isEmpty(appid) || StringUtils.isEmpty(secret)) {
            return null;
        }
        String password = DesUtils.decryptBasedDes(getSecret());
        String l = String.valueOf(System.currentTimeMillis());
        String substring = l.substring(0, 10);
        String s = Md5Utils.md5ToLowerCase(getAppid() + password + substring);
        LoginRequest request = new LoginRequest();
        request.setAppId(getAppid());
        request.setTimestamp(substring);
        request.setSign(s);
        try {
            if (StringUtils.isEmpty(request.getAppId()) || StringUtils.isEmpty(request.getTimestamp()) || StringUtils.isEmpty(request.getSign())) {
                throw new IllegalArgumentException("param error");
            }
            LoginResponse loginResponse = invoke(true, "/auth/token", request, LoginResponse.class);
            if (loginResponse == null) {
                throw new RuntimeException("get token failed");
            }
            return "Bearer " + loginResponse.getData().getAccessToken();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <Request, Response> Response invoke(boolean isLogin, String operation, Request request, Class<Response> responseClass) throws Exception {
        if (StringUtils.isBlank(operation)) {
            throw new IllegalArgumentException("Argument 'operation' can not be null or white space");
        }
        if (request == null) {
            throw new IllegalArgumentException("Argument 'request' can not be null");
        }

        ExecutionContext<Response> context = createExecutionContext(operation, request, responseClass);

        return invokeInternal(isLogin, context, false);
    }

    private <Response> Response invokeInternal(boolean isLogin, ExecutionContext<Response> context, boolean tokenRetry) throws Exception {
        CloseableHttpResponse httpResponse = null;
        try {
            HttpPost httpPost = prepareWebRequest(context, isLogin);
            httpResponse = executeWithRetry(httpPost, context);
            context.setResponse(httpResponse);
            checkHttpResponseStatus(httpResponse);
            Response response = deserializeResponse(httpResponse, context);
            checkResponseStatus(response);
            return response;
        } catch (TokenExpiredException e) {
            if (!tokenRetry) {
                if (System.currentTimeMillis() - tokenUpdateTime < 30 * 60 * 1000) {
                    synchronized (this) {
                        if (System.currentTimeMillis() - tokenUpdateTime < 30 * 60 * 1000) {
                            this.token = createToken(this.appid, this.secret);
                            this.tokenUpdateTime = System.currentTimeMillis() / (1000 * 60);
                            return invokeInternal(isLogin, context, true);
                        }
                    }
                }
            }
            throw e;
        } catch (Throwable e) {
            throw e;
        } finally {
            closeStream(httpResponse);
            silentClose(httpResponse);
        }
    }

    private void silentClose(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {

        }
    }

    private void closeStream(CloseableHttpResponse response) {
        if (response == null) {
            return;
        }
        HttpEntity httpEntity = response.getEntity();
        if (httpEntity != null) {
            EntityUtils.consumeQuietly(httpEntity);
        }
    }

    private <Response> void checkResponseStatus(Response response) throws Exception {
        String code = null;
        String msg = null;
        try {
            Class<?> aClass = response.getClass().getSuperclass();
            Field codeField = aClass.getDeclaredField("code");
            codeField.setAccessible(true);
            code = (String) codeField.get(response);
            Field msgField = aClass.getDeclaredField("msg");
            msgField.setAccessible(true);
            msg = (String) msgField.get(response);
        } catch (Exception e) {
            throw e;
        }
        if (null != code && code.equals("200")) {
            return;
        }
        if (null != code && code.equals("303")) {
            throw new TokenExpiredException();
        }
        throw new Exception(code + " " + msg);
    }

    private <Response> Response deserializeResponse(CloseableHttpResponse httpResponse, ExecutionContext<Response> context) throws IOException {
        Class<Response> clazz = context.getResponseClass();
        InputStream inputStream = getResponseStream(httpResponse, context);
        try {
            return objectMapper.readValue(inputStream, clazz);
        } catch (Exception e) {
            throw e;
        }
    }

    private <Response> InputStream getResponseStream(CloseableHttpResponse httpResponse, ExecutionContext<Response> context) throws IOException {
        InputStream inputStream = httpResponse.getEntity().getContent();
        try {
            byte[] rawContent = IOUtils.toByteArray(inputStream);
            inputStream = new ByteArrayInputStream(rawContent);
            return inputStream;
        } catch (Exception e) {
            throw e;
        }
    }

    private void checkHttpResponseStatus(CloseableHttpResponse httpResponse) throws Exception {
        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            return;
        }
        String responseContent = getResponseContent(httpResponse);
        StatusLine status = httpResponse.getStatusLine();
        int statusCode = status.getStatusCode();
        String reasonPhrase = status.getReasonPhrase();
        throw new Exception(statusCode + " " + reasonPhrase + " " + responseContent);
    }

    private String getResponseContent(HttpResponse response) {
        String responseContent = null;
        InputStreamReader reader = null;
        try {
            char[] buffer = new char[512];
            StringBuilder builder = new StringBuilder();
            reader = new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8);
            int length;
            while ((length = reader.read(buffer, 0, buffer.length)) >= 0) {
                builder.append(buffer, 0, length);
            }
            responseContent = builder.toString();
        } catch (IOException e) {

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
            try {
                if (response instanceof CloseableHttpResponse) {
                    ((CloseableHttpResponse) response).close();
                }
            } catch (IOException e) {

            }
        }
        return responseContent;
    }

    private <Response> CloseableHttpResponse executeWithRetry(HttpPost httpPost, ExecutionContext<Response> context) throws Exception {
        int executionCount = 0;
        IOException retryException = null;
        while (canRetry(executionCount)) {
            try {
                return execute(httpPost, context);
            } catch (Exception e) {
                if (e instanceof ConnectException || e instanceof ConnectTimeoutException) {
                    retryException = (IOException) e;
                } else {
                    throw e;
                }
            }
            context = createExecutionContext(context.getOperation(), context.getRequest(), context.getResponseClass());
            httpPost = prepareWebRequest(context, false);
            httpPost.addHeader("retry", String.valueOf(executionCount));
            executionCount++;
        }
        throw retryException;
    }

    private boolean isRetryException(IOException e) {
        return e instanceof ConnectException || e instanceof ConnectTimeoutException;
    }

    private <Response> CloseableHttpResponse execute(HttpPost httpPost, ExecutionContext<Response> context) throws IOException {
        return client.execute(httpPost);
    }

    private boolean canRetry(int executionCount) {
        return executionCount <= retry;
    }

    private <Response> void validate(ExecutionContext<Response> context) {
        //todo 业务参数校验
    }

    private <Response> HttpPost prepareWebRequest(ExecutionContext<Response> context, boolean isLogin) throws Exception {
        String requestUri = context.getUrl();
        HttpPost httpPost = new HttpPost(requestUri);

        RequestConfig requestConfig = createRequestConfig(context);
        httpPost.setConfig(requestConfig);

        for (Map.Entry<String, String> header : headers.entrySet()) {
            httpPost.addHeader(header.getKey(), header.getValue());
        }

        if (!isLogin) {
            System.out.println("token = " + this.token);
            httpPost.addHeader("Authorization", StringUtils.isEmpty(this.token) ? createSign(context) : this.token);
        }
        httpPost.addHeader("Content-Type", "application/json");

        serializeRequest(context, httpPost);

        return httpPost;
    }

    private <Response> void serializeRequest(ExecutionContext<Response> context, HttpPost httpPost) throws IOException {
        try {
            byte[] bytes = objectMapper.writeValueAsBytes(context.getRequest());
            HttpEntity httpEntity = new ByteArrayEntity(bytes);
            httpPost.setEntity(httpEntity);
        } catch (Exception e) {
            throw e;
        }
    }

    private <Response> String createSign(ExecutionContext<Response> context) throws Exception {
        String password = DesUtils.decryptBasedDes(secret);
        String l = String.valueOf(System.currentTimeMillis());
        String substring = l.substring(0, 10);
        String s = Md5Utils.md5ToLowerCase(appid + password + substring);
        LoginRequest request = new LoginRequest();
        request.setAppId(appid);
        request.setTimestamp(substring);
        request.setSign(s);
        if (StringUtils.isEmpty(request.getAppId()) || StringUtils.isEmpty(request.getTimestamp()) || StringUtils.isEmpty(request.getSign())) {
            throw new IllegalArgumentException("param error");
        }
        LoginResponse loginResponse = invoke(true, "/auth/token", request, LoginResponse.class);
        String accessToken = loginResponse.getData().getAccessToken();
        return "Bearer " + accessToken;
    }

    private <Response> RequestConfig createRequestConfig(ExecutionContext<Response> context) {
        return RequestConfig.custom().setConnectionRequestTimeout(requestTimout).setConnectTimeout(connectTimeout).setSocketTimeout(socketTimout).build();
    }

    private <Response, Request> ExecutionContext<Response> createExecutionContext(String operation, Request request, Class<Response> responseClass) throws URISyntaxException {
        ExecutionContext<Response> executionContext = new ExecutionContext<>();
        executionContext.setOperation(operation);
        executionContext.setRequest(request);
        executionContext.setResponseClass(responseClass);

        String url = BASE_URL + operation;
        URI uri = new URI(url);
        executionContext.setUri(uri);
        executionContext.setUrl(url);
        return executionContext;
    }


    public void setRetry(int retry) {
        this.retry = retry;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public void setSocketTimout(int socketTimout) {
        this.socketTimout = socketTimout;
    }

    public void setRequestTimout(int requestTimout) {
        this.requestTimout = requestTimout;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
