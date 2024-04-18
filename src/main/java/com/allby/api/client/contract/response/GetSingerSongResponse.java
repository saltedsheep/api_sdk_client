package com.allby.api.client.contract.response;


import com.allby.api.client.contract.SongInfoData;

import java.util.List;

public class GetSingerSongResponse extends BaseResponse {
    private SingerSongInfo data;
}

class SingerSongInfo {
    private String name;

    private String code;

    private List<SongInfoData> songs;

    private Integer pageNo;

    private Integer pageSize;

    private Integer total;
}
