package com.allby.api.client.contract.response;


import com.allby.api.client.contract.AlbumData;

import java.util.List;

public class GetSingerAlbumResponse extends BaseResponse {
    private SingerAlbumInfo data;
}

class SingerAlbumInfo {
    private String name;

    private String code;

    private List<AlbumData> albums;

    private Integer pageNo;

    private Integer pageSize;

    private Integer total;
}
