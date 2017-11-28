package com.bwei.guoyongzhen20171123.model;

import com.bwei.guoyongzhen20171123.bean.Shipin;
import com.bwei.guoyongzhen20171123.net.Api;
import com.bwei.guoyongzhen20171123.net.Apiservce;
import com.bwei.guoyongzhen20171123.net.Onnext;
import com.bwei.guoyongzhen20171123.net.RetrofitUtils;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by GUO on 2017/11/23.
 */

public class Shipinmodel {
    public  void  ShipinModel(final Onnext onnext, String id){
        final Retrofit retrofit = RetrofitUtils.getRetrofit(Api.QINGQIU);
        final Apiservce apiservce = retrofit.create(Apiservce.class);
        final Observable<Shipin> observable = apiservce.GetShipin(id);
      observable.subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new Subscriber<Shipin>() {
                  @Override
                  public void onCompleted() {

                  }

                  @Override
                  public void onError(Throwable e) {

                  }

                  @Override
                  public void onNext(Shipin shipin) {
                   onnext.Onseccess(shipin);
                  }
              });
    }
}
