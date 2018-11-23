package com.example.user.viewpagedemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.viewpagedemo.R;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;



    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_images={
            R.drawable.cake,
            R.drawable.cake2,
            R.drawable.g01

    };

    public String[] slide_headings={
            "東",
            "西",
            "南"

    };

    public String[] slide_des={
            "hahaha",
            "yayaya",
            "hihihi"

    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {


        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView sliderImagver = view.findViewById(R.id.slide_image);
        TextView slideHandering = view.findViewById(R.id.slide_textview);
        TextView slideDesc = view.findViewById(R.id.slide_textview);

        sliderImagver.setImageResource(slide_images[position]);
        slideHandering.setText(slide_headings[position]);
        slideDesc.setText(slide_des[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
