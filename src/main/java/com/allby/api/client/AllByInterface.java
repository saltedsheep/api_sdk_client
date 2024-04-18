package com.allby.api.client;

import com.allby.api.client.contract.request.*;
import com.allby.api.client.contract.response.*;

public interface AllByInterface {

    GetBehaviorInfoResponse getBehaviorInfo(GetBehaviorInfoReportRequest request) throws Exception;

    GetAlbumInfoResponse getAlbumInfo(GetAlbumInfoRequest request) throws Exception;

    GetAlbumSongResponse getAlbumSong(GetAlbumSongRequest request) throws Exception;

    GetSongByNameResponse getSongByName(GetSongByNameRequest request) throws Exception;

    GetSongUrlResponse getSongUrl(GetSongUrlRequest request) throws Exception;

    GetAlbumResponse getAlbum(GetAlbumRequest request) throws Exception;

    GetLibSongResponse getLibSong(GetLibSongRequest request) throws Exception;

    GetLibClientResponse getLibClient(GetLibClientRequest request) throws Exception;

    GetSongInfoResponse getSongInfo(GetSongInfoRequest request) throws Exception;

    LoginResponse getAccessToken(LoginRequest request) throws Exception;

    GetSingerAlbumResponse getSingerAlbum(GetSingerAlbumRequest request) throws Exception;

    GetSingerSongResponse getSingerSongByName(GetSingerSongRequest request) throws Exception;

    GetSingerByNameResponse getSingerByName(GetSingerByNameRequest request) throws Exception;

    GetSingerInfoResponse getSingerInfo(GetSingerInfoRequest request) throws Exception;
}
