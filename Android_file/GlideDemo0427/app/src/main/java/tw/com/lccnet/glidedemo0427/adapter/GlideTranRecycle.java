package tw.com.lccnet.glidedemo0427.adapter;

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

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.MaskTransformation;
import tw.com.lccnet.glidedemo0427.R;
import tw.com.lccnet.glidedemo0427.Utils;
import tw.com.lccnet.glidedemo0427.model.GlideAll;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;
import static com.bumptech.glide.request.RequestOptions.overrideOf;

public class GlideTranRecycle extends RecyclerView.Adapter<GlideTranRecycle.ViewHolder>{
    Context ctx;
List<String>mData=new ArrayList<>();
    public GlideTranRecycle(Context ctx) {
        this.ctx = ctx;
        for(int i=1;i<=21;i++){
            mData.add(i+"");
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView=View.inflate(ctx, R.layout.item_glide_tra,null);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
/*        int integer=Integer.parseInt(mData.get(position));
        int width = Utils.dip2px(ctx, 266.66f);
        int height = Utils.dip2px(ctx, 252.66f);
        switch (integer){
            case 1:
                Glide.with(ctx).load(R.drawable.pk)
                        .apply(overrideOf(width, height))
                        .apply(bitmapTransform(new MultiTransformation<>(new CenterCrop(),
                                new MaskTransformation(R.drawable.girl))))
                        .into(holder.iv_glide);
                break;
        }*/
        int integer=Integer.parseInt(mData.get(position));
        switch (integer) {
            case 1:
                new GlideAll(ctx).setMask(R.drawable.pk,holder.iv_glide);
                break;
            case 2:
                new GlideAll(ctx).setNinePatchMask(R.drawable.pk,holder.iv_glide);
                break;
            case 3:
                new GlideAll(ctx).setCropTop(R.drawable.pk,holder.iv_glide);
                break;
            case 4:
                new GlideAll(ctx).setCropCenter(R.drawable.pk,holder.iv_glide);
                break;
            case 5:
                new GlideAll(ctx).setCropBottom(R.drawable.pk,holder.iv_glide);
                break;
            case 6:
                new GlideAll(ctx).setCropSquare(R.drawable.pk,holder.iv_glide);
                break;
            case 7:
                new GlideAll(ctx).setCropCircle(R.drawable.pk,holder.iv_glide);
                break;
            case 8:
                new GlideAll(ctx).setColorFilter(R.drawable.pk,holder.iv_glide);
                break;
            case 9:
                new GlideAll(ctx).setGrayscale(R.drawable.pk,holder.iv_glide);
                break;
            case 10:
                new GlideAll(ctx).setRoundedCorners(R.drawable.pk,holder.iv_glide);
                break;
            case 11:
                new GlideAll(ctx).setBlur(R.drawable.pk,holder.iv_glide);
                break;
            case 12:
                new GlideAll(ctx).setToon(R.drawable.pk,holder.iv_glide);
                break;
            case 13:
                new GlideAll(ctx).setSepia(R.drawable.pk,holder.iv_glide);
                break;
            case 14:
                new GlideAll(ctx).setContrast(R.drawable.pk,holder.iv_glide);
                break;
            case 15:
                new GlideAll(ctx).setInvert(R.drawable.pk,holder.iv_glide);
                break;
            case 16:
                new GlideAll(ctx).setPixel(R.drawable.pk,holder.iv_glide);
                break;
            case 17:
                new GlideAll(ctx).setSketch(R.drawable.pk,holder.iv_glide);
                break;
            case 18:
                new GlideAll(ctx).setSwirl(R.drawable.pk,holder.iv_glide);
                break;
            case 19:
                new GlideAll(ctx).setBrightness(R.drawable.pk,holder.iv_glide);
                break;
            case 20:
                new GlideAll(ctx).setKuawahara(R.drawable.pk,holder.iv_glide);
                break;
            case 21:
                new GlideAll(ctx).setVignette(R.drawable.pk,holder.iv_glide);
                break;

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
            tv_glide=itemView.findViewById(R.id.tv_glide_tra);
            iv_glide=itemView.findViewById(R.id.iv_glide_tra);
        }
    }
}
