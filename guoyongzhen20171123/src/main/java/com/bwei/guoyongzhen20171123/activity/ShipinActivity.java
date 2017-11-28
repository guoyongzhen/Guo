package com.bwei.guoyongzhen20171123.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bwei.guoyongzhen20171123.R;
import com.bwei.guoyongzhen20171123.adapter.Fragment1;
import com.bwei.guoyongzhen20171123.adapter.Fragment2;
import com.bwei.guoyongzhen20171123.adapter.FragmentAdapter;
import com.bwei.guoyongzhen20171123.bean.Shipin;
import com.bwei.guoyongzhen20171123.presenter.Shipinpresenter;
import com.bwei.guoyongzhen20171123.view.Shipinview;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

import tv.danmaku.ijk.media.widget.media.AndroidMediaController;
import tv.danmaku.ijk.media.widget.media.IjkVideoView;

/**
 * 播放视频
 */
public class ShipinActivity extends AppCompatActivity implements Shipinview {
    private String name;
    private IjkVideoView videoView;
    private TabLayout mTablayout;
    private ViewPager mViewpager;
private  FragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipin);
        initView();
        final ArrayList<Fragment> fragments = new ArrayList<>();
        StatusBarUtil.setTransparent(ShipinActivity.this);
        final Intent intent = getIntent();
        name = intent.getStringExtra("id");
        final String name1 = intent.getStringExtra("name");
//        mTv.setText(name1);
        Toast.makeText(ShipinActivity.this, this.name, Toast.LENGTH_LONG).show();
        Show();

        final Fragment1 fragment1 = new Fragment1();
        final Fragment2 fragment2 = new Fragment2();
        fragments.add(fragment1);
        fragments.add(fragment2);

        adapter = new FragmentAdapter(getSupportFragmentManager(),fragments);
        mViewpager.setAdapter(adapter);
        mTablayout.setupWithViewPager(mViewpager);
    }

    private void Show() {
        final Shipinpresenter shipinpresenter = new Shipinpresenter(this);
        shipinpresenter.Guanlian(name);
    }

    private void initView() {
        videoView = (IjkVideoView) findViewById(R.id.ijkPlayer);

        mTablayout = (TabLayout) findViewById(R.id.tablayout);
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
    }

    //guanlian
    @Override
    public void ShipinView(Shipin shipin) {
        //视频播放
        final String hdurl = shipin.getRet().getHDURL();
        AndroidMediaController controller = new AndroidMediaController(this, false);
        videoView.setMediaController(controller);
        videoView.setVideoURI(Uri.parse(hdurl));
        videoView.start();
        final String actors = shipin.getRet().getActors();
      //  shipin.getRet().getList().get()
    }


}
