package com.allby.api.client;

import com.allby.api.client.contract.Page;
import com.allby.api.client.contract.SceneInfo;
import com.allby.api.client.contract.request.*;
import com.allby.api.client.contract.response.*;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class AllByClientTestOne {

    private AllByClient client = AllByClient.newBuilder().appid("song").secret("FgwS8pJXXDo=").build();

    @Test
    public void behaviorInfo() throws Exception {
        GetBehaviorInfoReportRequest request = new GetBehaviorInfoReportRequest();
        request.setDeviceId("PC123456");
        request.setImei("354896072431254");
        request.setMac("00-1A-2B-3C-4D-5E");
        request.setBeginTime("2024-04-07 00:00:00");
        request.setSongId("MLS1e2479f06");
        request.setType(2);
        request.setDuration(120);
        GetBehaviorInfoResponse response = client.getBehaviorInfo(request);
        System.out.println(response.getCode());
    }
    @Test
    public void albumInfo() throws Exception {
        GetAlbumInfoRequest request = new GetAlbumInfoRequest();

        //设置第一个code为MLA7d7e55c06，设置第二个code为MLA805c72b00
        request.setCodes(Lists.newArrayList("MLA7d7e55c06","MLA805c72b00"));
        SceneInfo sceneInfo = new SceneInfo();
        sceneInfo.setArea("CHN");
        sceneInfo.setSceneType(1);
        sceneInfo.setClientCode("025c232aa6b16e81f88181ce43c99449d1828b403fc7a567ecb53f5ec4ef32db");
        request.setSceneInfo(sceneInfo);
        GetAlbumInfoResponse response = client.getAlbumInfo(request);
        System.out.println(response.getCode());
    }
    @Test
    public void albumSong() throws Exception {
        GetAlbumSongRequest request = new GetAlbumSongRequest();
        request.setCode("MLA805c72b00");
        Page page = new Page();
        page.setNo(0);
        page.setSize(1);
        request.setPage(page);
        SceneInfo sceneInfo = new SceneInfo();
        sceneInfo.setArea("CHN");
        sceneInfo.setSceneType(1);
        sceneInfo.setClientCode("025c232aa6b16e81f88181ce43c99449d1828b403fc7a567ecb53f5ec4ef32db");
        request.setSceneInfo(sceneInfo);
        GetAlbumSongResponse response = client.getAlbumSong(request);
        System.out.println(response.getCode());
    }

    @Test
    public void album() throws Exception {
        GetAlbumRequest request = new GetAlbumRequest();
        request.setName("大牌");
        Page page = new Page();
        page.setNo(0);
        page.setSize(10);
        request.setPage(page);
        SceneInfo sceneInfo = new SceneInfo();
        sceneInfo.setArea("CHN");
        sceneInfo.setSceneType(1);
        sceneInfo.setClientCode("025c232aa6b16e81f88181ce43c99449d1828b403fc7a567ecb53f5ec4ef32db");
        request.setSceneInfo(sceneInfo);
        GetAlbumResponse response = client.getAlbum(request);
        System.out.println(response.getCode());
    }

    @Test
    public void libSong() throws Exception {
        GetLibSongRequest request = new GetLibSongRequest();
        request.setCode("61");
        Page page = new Page();
        page.setNo(0);
        page.setSize(1);
        request.setPage(page);
        SceneInfo sceneInfo = new SceneInfo();
        sceneInfo.setArea("CHN");
        sceneInfo.setSceneType(1);
        sceneInfo.setClientCode("025c232aa6b16e81f88181ce43c99449d1828b403fc7a567ecb53f5ec4ef32db");
        request.setSceneInfo(sceneInfo);
        GetLibSongResponse response = client.getLibSong(request);
        System.out.println(response.getCode());
    }

    @Test
    public void libClient() throws Exception {
        GetLibClientRequest request = new GetLibClientRequest();
        SceneInfo sceneInfo = new SceneInfo();
        sceneInfo.setArea("CHN");
        sceneInfo.setSceneType(1);
        sceneInfo.setClientCode("025c232aa6b16e81f88181ce43c99449d1828b403fc7a567ecb53f5ec4ef32db");
        request.setSceneInfo(sceneInfo);
        GetLibClientResponse response = client.getLibClient(request);
        System.out.println(response.getCode());
    }

    @Test
    public void songInfo() throws Exception {
        GetSongInfoRequest request = new GetSongInfoRequest();
        SceneInfo sceneInfo = new SceneInfo();
        sceneInfo.setArea("CHN");
        sceneInfo.setSceneType(1);
        sceneInfo.setClientCode("025c232aa6b16e81f88181ce43c99449d1828b403fc7a567ecb53f5ec4ef32db");
        request.setSceneInfo(sceneInfo);
        request.setCodes(Lists.newArrayList("MLS1e2479f06"));
        GetSongInfoResponse response = client.getSongInfo(request);
        System.out.println(response.getCode());
    }

    @Test
    public void songUrl() throws Exception {
        GetSongUrlRequest request = new GetSongUrlRequest();
        SceneInfo sceneInfo = new SceneInfo();
        sceneInfo.setArea("CHN");
        sceneInfo.setSceneType(1);
        sceneInfo.setClientCode("025c232aa6b16e81f88181ce43c99449d1828b403fc7a567ecb53f5ec4ef32db");
        request.setSceneInfo(sceneInfo);
        request.setCodes(Lists.newArrayList("MLS1e2479f06"));
        request.setVersion(1);
        GetSongUrlResponse response = client.getSongUrl(request);
        System.out.println(response.getCode());
    }

    @Test
    public void songByName() throws Exception {
        GetSongByNameRequest request = new GetSongByNameRequest();
        SceneInfo sceneInfo = new SceneInfo();
        sceneInfo.setArea("CHN");
        sceneInfo.setSceneType(1);
        sceneInfo.setClientCode("025c232aa6b16e81f88181ce43c99449d1828b403fc7a567ecb53f5ec4ef32db");

        Page page = new Page();
        page.setNo(0);
        page.setSize(5);

        request.setPage(page);
        request.setName("我爱");
        request.setSceneInfo(sceneInfo);

        GetSongByNameResponse response = client.getSongByName(request);
        System.out.println(response.getCode());
    }

    @Test
    public void singerInfo() throws Exception {
        GetSingerInfoRequest request = new GetSingerInfoRequest();
        request.setCodes(Lists.newArrayList("MLSI1801703"));
        GetSingerInfoResponse response = client.getSingerInfo(request);
        System.out.println(response.getCode());
    }

    @Test
    public void singerByName() throws Exception {
        GetSingerByNameRequest request = new GetSingerByNameRequest();
        SceneInfo sceneInfo = new SceneInfo();
        sceneInfo.setArea("CHN");
        sceneInfo.setSceneType(1);
        sceneInfo.setClientCode("025c232aa6b16e81f88181ce43c99449d1828b403fc7a567ecb53f5ec4ef32db");

        Page page = new Page();
        page.setNo(0);
        page.setSize(5);

        request.setPage(page);
        request.setName("陈");
        request.setSceneInfo(sceneInfo);

        GetSingerByNameResponse response = client.getSingerByName(request);
        System.out.println(response.getCode());
    }

    @Test
    public void singerSongByName() throws Exception {
        GetSingerSongRequest request = new GetSingerSongRequest();
        SceneInfo sceneInfo = new SceneInfo();
        sceneInfo.setArea("CHN");
        sceneInfo.setSceneType(1);
        sceneInfo.setClientCode("025c232aa6b16e81f88181ce43c99449d1828b403fc7a567ecb53f5ec4ef32db");

        Page page = new Page();
        page.setNo(0);
        page.setSize(5);

        request.setPage(page);
        request.setCode("MLSIce4cd4902");
        request.setSceneInfo(sceneInfo);

        GetSingerSongResponse response = client.getSingerSongByName(request);
        System.out.println(response.getCode());
    }

    @Test
    public void singerAlbum() throws Exception {
        GetSingerAlbumRequest request = new GetSingerAlbumRequest();
        SceneInfo sceneInfo = new SceneInfo();
        sceneInfo.setArea("CHN");
        sceneInfo.setSceneType(1);
        sceneInfo.setClientCode("025c232aa6b16e81f88181ce43c99449d1828b403fc7a567ecb53f5ec4ef32db");

        Page page = new Page();
        page.setNo(0);
        page.setSize(5);

        request.setPage(page);
        request.setCode("MLSI696646305");
        request.setSceneInfo(sceneInfo);

        GetSingerAlbumResponse response = client.getSingerAlbum(request);
        System.out.println(response.getCode());
    }

}