package com.allby.api.client.contract.utils;

import com.allby.api.client.contract.AlbumData;
import com.allby.api.client.contract.SongInfoData;

import java.util.List;

/**
 * Description :
 * Created by Angus on 2024/4/7 16:12
 */
public class AlbumSongResData {
    private String code;
    private String name;
    private String imgUrl;
    private List<SongInfoData> songs;
    private Integer pageNo;
    private Integer pageSize;
    private Integer total;
    private List<AlbumData> albums;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public List<AlbumData> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumData> albums) {
        this.albums = albums;
    }
}
