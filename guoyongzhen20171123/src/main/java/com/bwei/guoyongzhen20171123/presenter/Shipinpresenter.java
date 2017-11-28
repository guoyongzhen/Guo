package com.bwei.guoyongzhen20171123.presenter;

import com.bwei.guoyongzhen20171123.bean.Shipin;
import com.bwei.guoyongzhen20171123.model.Shipinmodel;
import com.bwei.guoyongzhen20171123.net.Onnext;
import com.bwei.guoyongzhen20171123.view.Shipinview;

/**
 * Created by GUO on 2017/11/23.
 */

public class Shipinpresenter implements Onnext{
    Shipinview shipinview;
    private final Shipinmodel shipinmodel;

    public Shipinpresenter(Shipinview shipinview) {
        this.shipinview=shipinview;
        shipinmodel = new Shipinmodel();
    }
    public  void  Guanlian(String id){
          shipinmodel.ShipinModel(this,id);
    }

    @Override
    public void Onseccess(Shipin shipin) {
     shipinview.ShipinView(shipin);
    }
}
