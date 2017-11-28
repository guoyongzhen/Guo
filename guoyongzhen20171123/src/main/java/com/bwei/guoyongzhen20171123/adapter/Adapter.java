package com.bwei.guoyongzhen20171123.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwei.guoyongzhen20171123.R;
import com.bwei.guoyongzhen20171123.bean.Bean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by GUO on 2017/11/23.
 */

public class Adapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<Bean.RetBean.ListBean.ChildListBean> listBeen;

    public Adapter(Context context, List<Bean.RetBean.ListBean.ChildListBean> listBeen) {
        this.context = context;
        this.listBeen = listBeen;
    }
    private  OnitemClick onitemClick;
    public  interface  OnitemClick{
        void  Onitem(Bean.RetBean.ListBean.ChildListBean list);
    }
public  void  setOnitemClick(OnitemClick onitemClick){
    this.onitemClick=onitemClick;
}
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.recyclerview, parent, false);
        final TypeViewHolder typeViewHolder = new TypeViewHolder(inflate);
        return typeViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
TypeViewHolder typeViewHolder= (TypeViewHolder) holder;
        typeViewHolder.textView.setText(listBeen.get(position).getTitle());
        final Uri parse = Uri.parse(listBeen.get(position).getPic());
        typeViewHolder.simpleDraweeView.setImageURI(parse);
  typeViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          if (onitemClick!=null){
              onitemClick.Onitem(listBeen.get(position));
          }
      }
  });
    }

    @Override
    public int getItemCount() {
        return listBeen.size();
    }
    private  class  TypeViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView simpleDraweeView;
        private final TextView textView;
        private final LinearLayout linearLayout;

        public TypeViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.sdv);
            textView = itemView.findViewById(R.id.tv);
            linearLayout = itemView.findViewById(R.id.ll);
        }
    }
}
