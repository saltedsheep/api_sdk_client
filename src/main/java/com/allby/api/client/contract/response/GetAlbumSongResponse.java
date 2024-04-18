package com.allby.api.client.contract.response;

import com.allby.api.client.contract.utils.AlbumSongResData;

/**
 * Description :
 * Created by Angus on 2024/4/7 10:48
 */
public class GetAlbumSongResponse extends BaseResponse {
    private static final long serialVersionUID = 101L;
    private AlbumSongResData data;

    public AlbumSongResData getData() {
        return data;
    }

    public void setData(AlbumSongResData data) {
        this.data = data;
    }
}
