package com.allby.api.client;

import com.allby.api.client.contract.request.*;
import com.allby.api.client.contract.response.*;
import com.allby.api.client.contract.task.TokenTimer;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.Timer;

public class AllByClient extends BaseClient implements AllByInterface {


    public AllByClient(String appid, String secret, boolean timerController) {
        super(appid, secret, timerController);
    }
    @Override
    public GetSingerAlbumResponse getSingerAlbum(GetSingerAlbumRequest request) throws Exception {
        if (request == null || StringUtils.isEmpty(request.getCode())) {
            throw new IllegalArgumentException("param error");
        }
        return super.invoke(false, "/singer/album/get", request, GetSingerAlbumResponse.class);
    }

    @Override
    public GetSingerSongResponse getSingerSongByName(GetSingerSongRequest request) throws Exception {
        if (request == null || StringUtils.isEmpty(request.getCode())) {
            throw new IllegalArgumentException("param error");
        }
        return super.invoke(false, "/singer/song/get", request, GetSingerSongResponse.class);
    }
    @Override
    public GetBehaviorInfoResponse getBehaviorInfo(GetBehaviorInfoReportRequest request) throws Exception {
        if (request == null || request.getSongId() == null || StringUtils.isEmpty(request.getDeviceId())) {
            throw new IllegalArgumentException("param error");
        }
        return super.invoke(false, "/playInfo/behaviorInfoReport", request, GetBehaviorInfoResponse.class);
    }
    @Override
    public GetAlbumInfoResponse getAlbumInfo(GetAlbumInfoRequest request) throws Exception {
        if (request == null || request.getSceneInfo() == null || StringUtils.isEmpty(request.getCodes().get(0))) {
            throw new IllegalArgumentException("param error");
        }
        return super.invoke(false, "/album/info/get", request, GetAlbumInfoResponse.class);
    }
    @Override
    public GetAlbumSongResponse getAlbumSong(GetAlbumSongRequest request) throws Exception {
        if (request == null || request.getSceneInfo() == null || request.getPage() == null || StringUtils.isEmpty(request.getCode())) {
            throw new IllegalArgumentException("param error");
        }
        return super.invoke(false, "/album/song/get", request, GetAlbumSongResponse.class);
    }

    public GetAlbumResponse getAlbum(GetAlbumRequest request) throws Exception {
        if (request == null || request.getSceneInfo() == null || request.getPage() == null || StringUtils.isEmpty(request.getName())) {
            throw new IllegalArgumentException("param error");
        }
        return super.invoke(false,"/album/get", request, GetAlbumResponse.class);
    }

    @Override
    public GetLibSongResponse getLibSong(GetLibSongRequest request) throws Exception {
        if (request == null || request.getSceneInfo() == null || request.getPage() == null || StringUtils.isEmpty(request.getCode())) {
            throw new IllegalArgumentException("param error");
        }
        return super.invoke(false,"/lib/song/get", request, GetLibSongResponse.class);
    }

    @Override
    public GetLibClientResponse getLibClient(GetLibClientRequest request) throws Exception {
        if (request == null || request.getSceneInfo() == null) {
            throw new IllegalArgumentException("param error");
        }
        return super.invoke(false,"/lib/client/get", request, GetLibClientResponse.class);
    }

    @Override
    public GetSingerByNameResponse getSingerByName(GetSingerByNameRequest request) throws Exception {
        if (request == null || StringUtils.isEmpty(request.getName())) {
            throw new IllegalArgumentException("param error");
        }
        return super.invoke(false, "/singer/get", request, GetSingerByNameResponse.class);
    }


    @Override
    public GetSingerInfoResponse getSingerInfo(GetSingerInfoRequest request) throws Exception {
        if (request == null || CollectionUtils.isEmpty(request.getCodes())) {
            throw new IllegalArgumentException("param error");
        }
        return super.invoke(false, "/singer/info/get", request, GetSingerInfoResponse.class);
    }

    @Override
    public GetSongByNameResponse getSongByName(GetSongByNameRequest request) throws Exception {
        if (request == null || StringUtils.isEmpty(request.getName())) {
            throw new IllegalArgumentException("param error");
        }
        return super.invoke(false, "/song/get", request, GetSongByNameResponse.class);
    }

    @Override
    public GetSongUrlResponse getSongUrl(GetSongUrlRequest request) throws Exception {
        if (request == null || CollectionUtils.isEmpty(request.getCodes())) {
            throw new IllegalArgumentException("param error");
        }
        return super.invoke(false, "/song/url/get", request, GetSongUrlResponse.class);
    }

    @Override
    public GetSongInfoResponse getSongInfo(GetSongInfoRequest request) throws Exception {
        if (request == null || CollectionUtils.isEmpty(request.getCodes())) {
            throw new IllegalArgumentException("param error");
        }
        return super.invoke(false, "/song/info/get", request, GetSongInfoResponse.class);
    }

    @Override
    public LoginResponse getAccessToken(LoginRequest request) throws Exception {
        if (request == null || StringUtils.isEmpty(request.getAppId()) || StringUtils.isEmpty(request.getTimestamp())
                || StringUtils.isEmpty(request.getSign())) {
            throw new IllegalArgumentException("param error");
        }
        return super.invoke(false, "/auth/token", request, LoginResponse.class);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {

        private String appid;
        private String secret;
        private boolean tokenRefresh;
        private boolean timerController;

        public boolean getTimerController() {
            return timerController;
        }

        public void setTimerController(boolean timerController) {
            this.timerController = timerController;
        }

        public Builder tokenRefresh(boolean tokenRefresh) {
            this.tokenRefresh = tokenRefresh;
            return this;
        }

        public Builder appid(String appid) {
            this.appid = appid;
            return this;
        }

        public Builder secret(String secret) {
            this.secret = secret;
            return this;
        }

        public AllByClient build() {
            if (StringUtils.isEmpty(appid) || StringUtils.isEmpty(secret)) {
                throw new IllegalArgumentException("param error");
            }
            AllByClient client = new AllByClient(appid, secret, tokenRefresh);
            if (timerController) {
                Timer timer = new Timer();
                TokenTimer task = new TokenTimer(client);
                long delay = 0; // 立即执行一次
                long period = 3600000; // 每隔3600秒执行一次
                timer.schedule(task, delay, period);
            }
            return client;
        }
    }
}
