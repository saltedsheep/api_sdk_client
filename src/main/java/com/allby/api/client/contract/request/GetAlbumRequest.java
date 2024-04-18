package com.allby.api.client.contract.request;

import com.allby.api.client.contract.Page;
import com.allby.api.client.contract.SceneInfo;

/**
 * Description :
 * Created by Angus on 2024/4/7 9:38
 */
public class GetAlbumRequest {
    private String name;
    private SceneInfo sceneInfo;
    private Page page;

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

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
