package com.allby.api.client.contract.request;

import com.allby.api.client.contract.SceneInfo;

import java.util.List;

public class GetSongUrlRequest {
    private List<String> codes;

    private SceneInfo sceneInfo;

    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

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
