package com.example.user.glidedemo.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.user.glidedemo.R;
import com.example.user.glidedemo.Utils;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.MaskTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;
import static com.bumptech.glide.request.RequestOptions.overrideOf;

public class GlideTranAdapter extends RecyclerView.Adapter<GlideTranAdapter.ViewHolder>{
    private Context ctx;
    private List<String> mData=new ArrayList<>();/*String型態是因為mData(圖片連接)*/
    public GlideTranAdapter(Context ctx) {
        this.ctx = ctx;/*因為設static,所以一開始就會跑建構子,就開始跑回圈*/
        for(int i=0;i<=21;i++){
            mData.add(i+"");
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview=View.inflate(ctx, R.layout.item_glide_tran,null);

        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int integer=Integer.parseInt(mData.get(position));
        switch (integer){
            case 0:
                int width = Utils.dip2px(ctx, 266.66f);
                int height = Utils.dip2px(ctx, 252.66f);
                Glide.with(ctx).load(R.drawable.g03)
                        .apply(overrideOf(width, height))
                        .apply(bitmapTransform(new MultiTransformation<>(new CenterCrop(),
                                new MaskTransformation(R.drawable.mask_starfish))))
                        .into(holder.iv_glide);
                break;
            case 1:
                Glide.with(ctx)
                        .load(R.drawable.g03)
                        .apply(bitmapTransform(new CropCircleTransformation()))
                        .into(holder.iv_glide);
                break;
            case 2:
                Glide.with(ctx)
                        .load(R.drawable.g03)
                        .apply(bitmapTransform(new CropCircleTransformation()))
                        .into(holder.iv_glide);
            case 3:
                int width1 = Utils.dip2px(ctx, 300.0f);
                int height1= Utils.dip2px(ctx, 200.0f);
                Glide.with(ctx)
                        .load(R.drawable.g04)
                        .apply(overrideOf(width1, height1))
                        .apply(bitmapTransform(new MultiTransformation<>(new CenterCrop(),
                                new MaskTransformation(R.drawable.g02))))
                        .into(holder.iv_glide);

        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_glide;
        TextView tv_glide;
        public ViewHolder(View itemView) {
            super(itemView);
            iv_glide=itemView.findViewById(R.id.im_glide_tran);
            tv_glide=itemView.findViewById(R.id.tv_glide_tran);

        }
    }

}
