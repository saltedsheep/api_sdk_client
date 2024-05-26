package com.allby.api.client.contract.response;


import java.util.List;

public class GetSongUrlResponse extends BaseResponse {

    private static final long serialVersionUID = 3568646821206875212L;

    private List<SongUrlData> data;

    public List<SongUrlData> getData() {
        return data;
    }

    public void setData(List<SongUrlData> data) {
        this.data = data;
    }
}

class SongUrlData {
    private String code;

    private String songName;

    private String message;

    private String url;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}