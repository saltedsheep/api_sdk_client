package com.allby.api.client.contract.response;


import com.allby.api.client.contract.SingerData;

import java.util.List;

public class GetSingerByNameResponse extends BaseResponse {
    private SingerData data;

    private List<SingerWithNameInfo> singers;
}

class SingerWithNameInfo {
    private Integer pageNo;

    private Integer pageSize;

    private Integer total;

    private List<SingerData> singers;
}
