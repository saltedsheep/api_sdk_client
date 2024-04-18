package com.allby.api.client.contract;

import java.util.List;

public class SongInfoData {
    private int id;
    private String code;
    private String name;
    private int duration;
    private String wordAuthor;
    private String tuneAuthor;
    private String area;
    private List<String> tagStrList;
    private String url;
    private List<AlbumData> albums;
    private List<SingerData> singers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getWordAuthor() {
        return wordAuthor;
    }

    public void setWordAuthor(String wordAuthor) {
        this.wordAuthor = wordAuthor;
    }

    public String getTuneAuthor() {
        return tuneAuthor;
    }

    public void setTuneAuthor(String tuneAuthor) {
        this.tuneAuthor = tuneAuthor;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<String> getTagStrList() {
        return tagStrList;
    }

    public void setTagStrList(List<String> tagStrList) {
        this.tagStrList = tagStrList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<AlbumData> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumData> albums) {
        this.albums = albums;
    }

    public List<SingerData> getSingers() {
        return singers;
    }

    public void setSingers(List<SingerData> singers) {
        this.singers = singers;
    }
}