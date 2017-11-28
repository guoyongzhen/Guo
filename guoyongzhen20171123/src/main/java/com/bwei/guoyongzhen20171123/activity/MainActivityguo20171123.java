package com.bwei.guoyongzhen20171123.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bwei.guoyongzhen20171123.R;
import com.bwei.guoyongzhen20171123.fragment.Fragmentjingxuan;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivityguo20171123 extends AppCompatActivity {
private  BottomTabBar mb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityguo20171123);
        mb=(BottomTabBar)findViewById(R.id.bottom_tab_bar);

        mb.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(8)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("精选",R.mipmap.found_select,R.mipmap.found, Fragmentjingxuan.class)
                .addTabItem("专题",R.mipmap.special_select,R.mipmap.special, Fragmentjingxuan.class)
                .addTabItem("发现",R.mipmap.fancy_select, R.mipmap.fancy,Fragmentjingxuan.class)
                .addTabItem("我的",R.mipmap.my_select,R.mipmap.my ,Fragmentjingxuan.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });

    }

}
