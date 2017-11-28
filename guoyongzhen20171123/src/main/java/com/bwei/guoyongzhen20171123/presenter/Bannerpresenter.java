package com.bwei.guoyongzhen20171123.presenter;

import com.bwei.guoyongzhen20171123.bean.Bean;
import com.bwei.guoyongzhen20171123.model.Bannermodel;
import com.bwei.guoyongzhen20171123.net.Onfinsh;
import com.bwei.guoyongzhen20171123.view.Banner;

/**
 * Created by GUO on 2017/11/23.
 */

public class Bannerpresenter implements Onfinsh  {
    Banner banner1;
    private final Bannermodel bannermodel;

    public Bannerpresenter(Banner banner1) {
    this.banner1=banner1;
        bannermodel = new Bannermodel();
    }
    public  void  Guanlian(){
        bannermodel.GetBannerModel(this);
    }

    @Override
    public void Onseccess(Bean bean) {
        banner1.BannerView(bean);
    }
}
