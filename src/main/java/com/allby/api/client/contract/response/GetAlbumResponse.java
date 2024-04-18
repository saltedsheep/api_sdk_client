package com.allby.api.client.contract.response;

import com.allby.api.client.contract.AlbumData;

import java.util.List;

/**
 * Description :
 * Created by Angus on 2024/4/7 10:04
 */
public class GetAlbumResponse extends BaseResponse {
    private static final long serialVersionUID = 100L;
    private AlbumResData data;

    public AlbumResData getData() {
        return data;
    }

    public void setData(AlbumResData data) {
        this.data = data;
    }

    public static class AlbumResData {
        private Integer pageNo;
        private Integer pageSize;
        private Integer total;
        private List<AlbumData> albums;

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
}
