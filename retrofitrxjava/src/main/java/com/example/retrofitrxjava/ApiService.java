package com.example.retrofitrxjava;


import com.example.retrofitrxjava.bean.News;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by GUO on 2017/11/3.
 */

public interface ApiService {
    /**
     * 无参
     */
    @GET("ads/cptj")
    Observable<News> getNoParams();
//注释要写好
}
