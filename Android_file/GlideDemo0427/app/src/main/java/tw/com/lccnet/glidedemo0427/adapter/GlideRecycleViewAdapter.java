package tw.com.lccnet.glidedemo0427.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import tw.com.lccnet.glidedemo0427.R;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class GlideRecycleViewAdapter extends RecyclerView.Adapter<GlideRecycleViewAdapter.ViewHolder> {
private  Context ctx;
    String[] mData=new String[]{
            "http://img3.jiche.com//bikes/3467/200/5343ae8446d7adb658699adce31ed996.jpg",
            "http://img5.jiche.com//bikes/4084/200/055d3c767221caf4a27a74ba3ebcd0c6.jpg",
            "http://img5.jiche.com//bikes/3409/200/69e8ad0e0d87f0ed06cf6b0e0400e3ac.jpg",
            "http://img5.jiche.com//bikes/3624/200/45afa258c4d7568315ecb5f4f03bd2e3.jpg",
            "http://img1.jiche.com//bikes/4055/200/2654b9e845c712b6a057dc685237c0d5.jpg",
    };

    public GlideRecycleViewAdapter(Context ctx) {
        this.ctx = ctx;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_glide_recycle);
        }
    }

    @NonNull
    @Override
    public GlideRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=View.inflate(ctx, R.layout.item_glide_recycleview,null);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GlideRecycleViewAdapter.ViewHolder holder, int position) {
        Glide.with(ctx)
                .load(mData[position])
                .apply(bitmapTransform(new CropCircleTransformation()))
                .into(holder.imageView);
        //  Glide.with(ctx).load(mData[position]).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mData==null?0:mData.length;
    }
}
