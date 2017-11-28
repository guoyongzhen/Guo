package com.bwei.guoyongzhen20171123.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.guoyongzhen20171123.R;

/**
 * Created by GUO on 2017/11/23.
 */

public class Fragmentjingxuan extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View inflate = inflater.inflate(R.layout.jingxuan, container, false);
        return inflate;
    }
}
