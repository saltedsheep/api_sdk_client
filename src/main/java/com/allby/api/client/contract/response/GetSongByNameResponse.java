package com.allby.api.client.contract.response;


import com.allby.api.client.contract.SongInfoData;

import java.util.List;

public class GetSongByNameResponse extends BaseResponse {
    private SongWithNameInfo data;

    public SongWithNameInfo getData() {
        return data;
    }

    public void setData(SongWithNameInfo data) {
        this.data = data;
    }
}

class SongWithNameInfo {
    private String searchName;

    private List<SongInfoData> songs;

    private Integer pageNo;
    private Integer pageSize;
    private Integer total;

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
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
}
