package com.allby.api.client.contract.response;


import com.allby.api.client.contract.SongInfoData;

import java.util.List;

public class GetSongByNameResponse extends BaseResponse {
    private SongWithNameInfo data;

}

class SongWithNameInfo {
    private String searchName;

    private List<SongInfoData> songs;
}
