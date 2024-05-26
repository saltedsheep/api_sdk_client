package com.allby.api.client.contract.response;


import com.allby.api.client.contract.SingerData;

import java.util.List;

public class GetSingerByNameResponse extends BaseResponse {

    private SingerWithNameInfo data;

    public SingerWithNameInfo getData() {
        return data;
    }

    public void setData(SingerWithNameInfo data) {
        this.data = data;
    }
}

class SingerWithNameInfo {
    private Integer pageNo;

    private Integer pageSize;

    private Integer total;

    private List<SingerData> singers;

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

    public List<SingerData> getSingers() {
        return singers;
    }

    public void setSingers(List<SingerData> singers) {
        this.singers = singers;
    }
}
