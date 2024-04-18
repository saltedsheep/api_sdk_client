package com.allby.api.client.contract.response;


import com.allby.api.client.contract.SongInfoData;

import java.util.List;

public class GetSongInfoResponse extends BaseResponse {

    private static final long serialVersionUID = 3568646821206875212L;

    private List<SongInfoData> data;

    public List<SongInfoData> getData() {
        return data;
    }

    public void setData(List<SongInfoData> data) {
        this.data = data;
    }
}