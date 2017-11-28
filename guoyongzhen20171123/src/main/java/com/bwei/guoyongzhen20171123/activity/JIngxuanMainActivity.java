package com.bwei.guoyongzhen20171123.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwei.guoyongzhen20171123.R;
import com.bwei.guoyongzhen20171123.adapter.Adapter;
import com.bwei.guoyongzhen20171123.app.Myimageloader;
import com.bwei.guoyongzhen20171123.bean.Bean;
import com.bwei.guoyongzhen20171123.presenter.Bannerpresenter;
import com.bwei.guoyongzhen20171123.presenter.Representer;
import com.bwei.guoyongzhen20171123.view.Recyclerview;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * banner   图片播放与跳转
 */
public class JIngxuanMainActivity extends AppCompatActivity implements com.bwei.guoyongzhen20171123.view.Banner,Recyclerview{

    private Banner mBanner;
    private RecyclerView mRv;
    private List<String > list=new ArrayList<String >();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jingxuan_main);
        initView();
        Banne();
        Re();
    }

    private void Re() {
        final Representer representer = new Representer(this);
        representer.Guanlian();
    }

    private void Banne() {
        final Bannerpresenter bannerpresenter = new Bannerpresenter(this);
        bannerpresenter.Guanlian();
    }

    private void initView() {
        mBanner = (Banner) findViewById(R.id.banner);
        mRv = (RecyclerView) findViewById(R.id.rv);
    }

    @Override
    public void BannerView(final Bean bean) {
        //Banner轮播
        final Bean bean1 = bean;
        for (int i=0;i<bean.getRet().getList().get(0).getChildList().size();i++){
            final String pic = bean.getRet().getList().get(0).getChildList().get(i).getPic();
            list.add(pic);
        }
        mBanner.setImageLoader(new Myimageloader());
        mBanner.setImages(list);
        mBanner.setDelayTime(2000);
        mBanner .start();
          mBanner.setOnBannerListener(new OnBannerListener() {
              @Override
              public void OnBannerClick(int position) {
                  final String dataId = bean.getRet().getList().get(0).getChildList().get(position).getDataId();
                  final Intent intent = new Intent(JIngxuanMainActivity.this, ShipinActivity.class);
                  final String description = bean.getRet().getList().get(0).getChildList().get(position).getDescription();
                  intent.putExtra("name",description);
                  intent.putExtra("id",dataId);
                  startActivity(intent);
              }
          });

    }

    @Override
    public void Review(Bean bean) {
        //recyclerview展示
        mRv.setLayoutManager(new LinearLayoutManager(this));
        final List<Bean.RetBean.ListBean.ChildListBean> childList = bean.getRet().getList().get(3).getChildList();
        final Adapter adapter = new Adapter(JIngxuanMainActivity.this, childList);
        mRv.setAdapter(adapter);
        adapter.setOnitemClick(new Adapter.OnitemClick() {
            @Override
            public void Onitem(Bean.RetBean.ListBean.ChildListBean list) {

                final Intent intent = new Intent(JIngxuanMainActivity.this, ShipinActivity.class);
                final String dataId = list.getDataId();
                //通过intent传值
                intent.putExtra("id",dataId);
                final String description = list.getDescription();
                intent.putExtra("name",description);
                startActivity(intent);
            }
        });
    }
}
