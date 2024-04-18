package com.allby.api.client.contract.response;


public class GetSongUrlResponse extends BaseResponse {

    private static final long serialVersionUID = 3568646821206875212L;

    private SongUrlData data;

    public SongUrlData getData() {
        return data;
    }

    public void setData(SongUrlData data) {
        this.data = data;
    }
}

class SongUrlData {
    private String code;

    private String songName;

    private String message;

    private String url;
}