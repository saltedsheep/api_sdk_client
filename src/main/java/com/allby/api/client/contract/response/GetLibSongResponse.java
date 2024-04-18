package com.allby.api.client.contract.response;

import com.allby.api.client.contract.AlbumData;
import com.allby.api.client.contract.SingerData;

import java.util.List;

/**
 * Description :
 * Created by Angus on 2024/4/6 22:15
 */
public class GetLibSongResponse extends BaseResponse{
    private static final long serialVersionUID = 11L;
    private LibSongData data;

    public LibSongData getData() {
        return data;
    }

    public void setData(LibSongData data) {
        this.data = data;
    }

    public static class LibSongData {

        private String code;
        private String name;
        private String descri;
        private Integer pageNo;
        private Integer pageSize;
        private Integer total;
        private List<SongData> songs;

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

        public String getDescri() {
            return descri;
        }

        public void setDescri(String descri) {
            this.descri = descri;
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

        public List<SongData> getSongs() {
            return songs;
        }

        public void setSongs(List<SongData> songs) {
            this.songs = songs;
        }
    }

    public static class SongData {

        private Integer id;
        private String code;
        private String name;
        private Integer duration;
        private String wordAuthor;
        private String tuneAuthor;
        private String area;
        private List<AlbumData> albums;
        private List<SingerData> singers;
        private List<String> tagStrList;
        private String url;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
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

        public Integer getDuration() {
            return duration;
        }

        public void setDuration(Integer duration) {
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
    }
}
