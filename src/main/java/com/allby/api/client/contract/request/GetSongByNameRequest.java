package com.allby.api.client.contract.request;

import com.allby.api.client.contract.Page;
import com.allby.api.client.contract.SceneInfo;

public class GetSongByNameRequest {
    private Page page;

    private String name;

    private SceneInfo sceneInfo;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SceneInfo getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo(SceneInfo sceneInfo) {
        this.sceneInfo = sceneInfo;
    }
}
