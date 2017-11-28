package com.bwei.guoyongzhen20171123.model;

import com.bwei.guoyongzhen20171123.bean.Bean;
import com.bwei.guoyongzhen20171123.net.Api;
import com.bwei.guoyongzhen20171123.net.Apiservce;
import com.bwei.guoyongzhen20171123.net.Onfinsh;
import com.bwei.guoyongzhen20171123.net.RetrofitUtils;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by GUO on 2017/11/23.
 */

public class Recyclermodel {
    public  void  ReModel(final Onfinsh onfinsh){
        final Retrofit retrofit = RetrofitUtils.getRetrofit(Api.QINGQIU);
        final Apiservce apiservce = retrofit.create(Apiservce.class);
        final Observable<Bean> observable = apiservce.GetQingqiu();
               observable.subscribeOn(Schedulers.io())
                       .observeOn(AndroidSchedulers.mainThread())
                       .subscribe(new Subscriber<Bean>() {
                           @Override
                           public void onCompleted() {

                           }

                           @Override
                           public void onError(Throwable e) {

                           }

                           @Override
                           public void onNext(Bean bean) {
onfinsh.Onseccess(bean);
                           }
                       });
    }
}
