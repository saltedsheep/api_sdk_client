package com.allby.api.client.contract.request;

import com.allby.api.client.contract.SceneInfo;


public class GetLibClientRequest {

    private SceneInfo sceneInfo;

    public SceneInfo getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo(SceneInfo sceneInfo) {
        this.sceneInfo = sceneInfo;
    }
}
