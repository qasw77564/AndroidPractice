package tw.com.lccnet.galleryapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import tw.com.lccnet.galleryapp.R;
import tw.com.lccnet.galleryapp.config.Config;
import tw.com.lccnet.galleryapp.model.GlideAll;

public class SilderAdapter extends PagerAdapter{
    private Context context;
    private LayoutInflater layoutInflater;
    private String path=Config.url_server;
    private ImageView imageView;

    public SilderAdapter(Context context){
        this.context=context;
    }
    public String[] slide_image=new String[]{
            path+"/images/guide1.jpeg",
            path+"/images/guide2.jpeg",
            path+"/images/guid3.jpg"
    };

    @Override
    public int getCount() {
        return slide_image.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.silder_layout,container,false);

        imageView=view.findViewById(R.id.imageView);
        Glide.with(context).load(slide_image[position]).into(imageView);


       // ImageView slideimage= view.findViewById(R.id.imageView);
       // slideimage.setImageResource(Integer.parseInt(slide_image[position]));


        container.addView(view);/*這一行跟List包一包同樣道理*/
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
