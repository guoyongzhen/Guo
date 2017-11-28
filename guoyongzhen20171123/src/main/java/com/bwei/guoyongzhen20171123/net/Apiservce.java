package com.bwei.guoyongzhen20171123.net;

import com.bwei.guoyongzhen20171123.bean.Bean;
import com.bwei.guoyongzhen20171123.bean.Shipin;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by GUO on 2017/11/23.
 */

public interface Apiservce {
    @GET("homePageApi/homePage.do")
    Observable <Bean> GetQingqiu();
    @GET("videoDetailApi/videoDetail.do")
    Observable <Shipin>   GetShipin(@Query("mediaId") String id);
}
