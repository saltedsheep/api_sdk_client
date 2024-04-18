package com.allby.api.client.contract.request;

import com.allby.api.client.contract.Page;
import com.allby.api.client.contract.SceneInfo;

import java.io.Serializable;

public class GetSingerAlbumRequest implements Serializable {

    private Page page;

    private String code;

    private SceneInfo sceneInfo;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SceneInfo getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo(SceneInfo sceneInfo) {
        this.sceneInfo = sceneInfo;
    }
}
