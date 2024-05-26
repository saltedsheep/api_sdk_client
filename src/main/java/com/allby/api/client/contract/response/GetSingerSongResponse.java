package com.allby.api.client.contract.response;


import com.allby.api.client.contract.SongInfoData;

import java.util.List;

public class GetSingerSongResponse extends BaseResponse {
    private SingerSongInfo data;

    public SingerSongInfo getData() {
        return data;
    }

    public void setData(SingerSongInfo data) {
        this.data = data;
    }
}

class SingerSongInfo {
    private String name;

    private String code;

    private List<SongInfoData> songs;

    private Integer pageNo;

    private Integer pageSize;

    private Integer total;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<SongInfoData> getSongs() {
        return songs;
    }

    public void setSongs(List<SongInfoData> songs) {
        this.songs = songs;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
