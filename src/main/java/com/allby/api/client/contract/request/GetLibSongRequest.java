package com.allby.api.client.contract.request;

import com.allby.api.client.contract.Page;
import com.allby.api.client.contract.SceneInfo;

/**
 * Description :
 * Created by Angus on 2024/4/6 22:00
 */
public class GetLibSongRequest {

    private String code;
    private SceneInfo sceneInfo;
    private Page page;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
