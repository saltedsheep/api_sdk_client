package com.allby.api.client.contract.task;

import com.allby.api.client.AllByClient;
import com.allby.api.client.BaseClient;
import com.allby.api.client.contract.request.LoginRequest;
import com.allby.api.client.contract.response.LoginResponse;
import com.allby.api.client.contract.utils.DesUtils;
import com.allby.api.client.contract.utils.Md5Utils;
import org.apache.commons.lang.StringUtils;

import java.util.TimerTask;

public class TokenTimer extends TimerTask {

    private AllByClient client;

    public TokenTimer(AllByClient client) {
        this.client = client;
    }

    @Override
    public void run() {
        if (StringUtils.isEmpty(BaseClient.appid) || StringUtils.isEmpty(BaseClient.secret)) {
            return;
        }
        String password = DesUtils.decryptBasedDes(BaseClient.secret);
        String l = String.valueOf(System.currentTimeMillis());
        String substring = l.substring(0, 10);
        String s = Md5Utils.md5ToLowerCase(BaseClient.appid + password + substring);
        LoginRequest request = new LoginRequest();
        request.setAppId(BaseClient.appid);
        request.setTimestamp(substring);
        request.setSign(s);
        try {
            LoginResponse loginResponse = client.getAccessToken(request);
            String token = loginResponse.getData().getAccessToken();
            client.setToken("Bearer " + token);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
