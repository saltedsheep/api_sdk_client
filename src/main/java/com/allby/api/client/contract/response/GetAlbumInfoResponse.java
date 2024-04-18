package com.allby.api.client.contract.response;

import com.allby.api.client.contract.AlbumData;

import java.util.List;

/**
 * Description :
 * Created by Angus on 2024/4/7 11:14
 */
public class GetAlbumInfoResponse extends BaseResponse{
    private static final long serialVersionUID = 110L;
    private List<AlbumData> data;

    public List<AlbumData> getData() {
        return data;
    }

    public void setData(List<AlbumData> data) {
        this.data = data;
    }
}
