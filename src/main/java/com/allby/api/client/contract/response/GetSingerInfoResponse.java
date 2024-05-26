package com.allby.api.client.contract.response;


import com.allby.api.client.contract.SingerData;

import java.util.List;

public class GetSingerInfoResponse extends BaseResponse {
    private List<SingerData> data;

    public List<SingerData> getData() {
        return data;
    }

    public void setData(List<SingerData> data) {
        this.data = data;
    }
}
