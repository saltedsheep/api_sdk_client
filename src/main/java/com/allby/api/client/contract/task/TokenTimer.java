package com.allby.api.client.contract.task;

import com.allby.api.client.AllByClient;

import java.util.TimerTask;

public class TokenTimer extends TimerTask {

    private AllByClient client;

    public TokenTimer(AllByClient client) {
        this.client = client;
    }

    @Override
    public void run() {
        client.setToken(client.createToken(client.getAppid(), client.getSecret()));
    }
}
