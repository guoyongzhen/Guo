package com.bwei.guoyongzhen20171123.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.bwei.guoyongzhen20171123.R;

public class WecomeActivity extends AppCompatActivity {
    /**
     * 跳转页面
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wecome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WecomeActivity.this,
                        JIngxuanMainActivity.class);
                startActivity(intent);
                finish();
            }

        }, 3000);

    }
}
