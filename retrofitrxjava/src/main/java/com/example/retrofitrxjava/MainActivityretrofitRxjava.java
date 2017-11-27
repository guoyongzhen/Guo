package com.example.retrofitrxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.retrofitrxjava.bean.News;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivityretrofitRxjava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityretrofit_rxjava);
        getNoParams();


    }

    private void getNoParams() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_PATH)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
       //生产事件
        Observable<News> noParams = apiService.getNoParams();
        //被观察者订阅观察 默认在同一个线程
      noParams.subscribeOn(Schedulers.io())////指定IO做耗时操作
              .observeOn(AndroidSchedulers.mainThread())//指定更新UI在主线程
              .subscribe(new Observer<News>() {
          @Override
          public void onCompleted() {//完成

          }

          @Override
          public void onError(Throwable e) {//错误

          }

          @Override
          public void onNext(News news) {//消费事件
              List<List<String>> dropdown = news.getDropdown();
              for (int i=0;i<dropdown.size();i++){
                  String s = dropdown.get(i).get(i).toString();
                  Log.e("aaa",s);
              }
          }
      });
    }


}
