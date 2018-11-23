package com.example.user.guidedemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.user.guidedemo.R;

public class SliderAdaapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;


    public SliderAdaapter(Context context){
        this.context=context;
    }

    public int[] slide_image={R.drawable.gui01,R.drawable.gui02,R.drawable.gui03};

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
    public Object instantiateItem(@NonNull ViewGroup container, int position) {/*position陣列索引值*/
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slider_layout,container,false);

        ImageView slideimage= view.findViewById(R.id.imageView);
        slideimage.setImageResource(slide_image[position]);

        container.addView(view);/*這一行跟List包一包同樣道理*/
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);



    }

}
