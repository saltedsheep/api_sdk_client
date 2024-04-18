package com.allby.api.client.contract.request;

import com.allby.api.client.contract.SceneInfo;

import java.io.Serializable;
import java.util.List;

public class GetSingerInfoRequest implements Serializable {

    private List<String> codes;

    private SceneInfo sceneInfo;

    public List<String> getCodes() {
        return codes;
    }

    public void setCodes(List<String> codes) {
        this.codes = codes;
    }

    public SceneInfo getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo(SceneInfo sceneInfo) {
        this.sceneInfo = sceneInfo;
    }
}
