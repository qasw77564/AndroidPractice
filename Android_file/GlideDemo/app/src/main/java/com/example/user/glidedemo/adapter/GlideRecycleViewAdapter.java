package com.example.user.glidedemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.user.glidedemo.R;

public class GlideRecycleViewAdapter extends RecyclerView.Adapter<GlideRecycleViewAdapter.ViewHolder> {
    String[] mData=new String[]{
            "https://www.ziyimall.com/file_img/products/63/201505/22/20150522160423llJYcBR3.jpg",
            "http://orientaldaily.on.cc/cnt/china_world/20170630/photo/0630-00180-038p2g4.jpg",
            "http://pic5.qqmofasi.com/2015/07/04/1793_URFeecg6Cr4CEBeRz6u0_square.jpg",
            "http://www.chtoen.com/image/%E7%83%A4%E9%9B%9E%E8%85%BF.jpg",
            "http://www.ay3.net/demo/free-template/f151/upload/images/201304/3301.jpg",
            "http://www.chtoen.com/image/%E7%86%B1%E7%82%92%E8%BE%A3%E5%AD%90%E9%9B%9E%E4%B8%81.jpg",
            "http://www.tokyjiao.com/wp-content/uploads/2018/03/2018031700410084170-love.jpg",
            "http://www.adaymag.com/wp-content/uploads/2016/05/adaymag-33e1bd0100000578-3574460-image-a-7-1462487302411-01-200x200.jpg",
            "http://www.kingball.com.tw/ezcatfiles/red118/img/img/2075/1269-2270.jpg",
            "http://the-sun.on.cc/cnt/lifestyle/20150506/photo/0506-00485-001p4g1.jpg"
            };
    private Context ctx;
    public GlideRecycleViewAdapter(Context ctx) {
        this.ctx=ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=View.inflate(ctx, R.layout.item_glide_recycle,null);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(ctx).load(mData[position]).into(holder.imview);

    }

    @Override
    public int getItemCount() {
        return mData==null?0:mData.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imview;
        public ViewHolder(View itemView) {
            super(itemView);
            imview=itemView.findViewById(R.id.iv_glide_recycleview);

        }
    }
}
