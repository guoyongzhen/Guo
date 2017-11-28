package com.bwei.guoyongzhen20171123.presenter;

import com.bwei.guoyongzhen20171123.bean.Bean;
import com.bwei.guoyongzhen20171123.model.Recyclermodel;
import com.bwei.guoyongzhen20171123.net.Onfinsh;
import com.bwei.guoyongzhen20171123.view.Recyclerview;

/**
 * Created by GUO on 2017/11/23.
 */

public class Representer implements Onfinsh {
    Recyclerview recyclerview1;
    private final Recyclermodel recyclermodel;


    public Representer(Recyclerview recyclerview1) {
        this.recyclerview1=recyclerview1;
        recyclermodel = new Recyclermodel();
    }
    public  void  Guanlian(){
       recyclermodel.ReModel(this);
    }


    @Override
    public void Onseccess(Bean bean) {
        recyclerview1.Review(bean);
    }
}
