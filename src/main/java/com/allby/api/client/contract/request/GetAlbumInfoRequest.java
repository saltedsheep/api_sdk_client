package com.allby.api.client.contract.request;

import com.allby.api.client.contract.SceneInfo;

import java.util.List;

/**
 * Description :
 * Created by Angus on 2024/4/7 11:10
 */
public class GetAlbumInfoRequest {
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
