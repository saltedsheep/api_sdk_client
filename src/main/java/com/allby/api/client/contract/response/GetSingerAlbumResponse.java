package com.allby.api.client.contract.response;


import com.allby.api.client.contract.AlbumData;

import java.util.List;

public class GetSingerAlbumResponse extends BaseResponse {
    private SingerAlbumInfo data;

    public SingerAlbumInfo getData() {
        return data;
    }

    public void setData(SingerAlbumInfo data) {
        this.data = data;
    }
}

class SingerAlbumInfo {
    private String name;

    private String code;

    private List<AlbumData> albums;

    private Integer pageNo;

    private Integer pageSize;

    private Integer total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<AlbumData> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumData> albums) {
        this.albums = albums;
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
