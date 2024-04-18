package com.allby.api.client;

import org.apache.http.HttpResponse;

import java.net.URI;

public class ExecutionContext<Response> {

    private String operation;
    private Object request;
    private Object response;
    private Class<Response> responseClass;
    private URI uri;
    private HttpResponse httpResponse;
    private String url;

    public Class<Response> getResponseClass() {
        return responseClass;
    }

    public void setResponseClass(Class<Response> responseClass) {
        this.responseClass = responseClass;
    }

    public HttpResponse getHttpResponse() {
        return httpResponse;
    }

    public void setHttpResponse(HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Object getRequest() {
        return request;
    }

    public void setRequest(Object request) {
        this.request = request;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
