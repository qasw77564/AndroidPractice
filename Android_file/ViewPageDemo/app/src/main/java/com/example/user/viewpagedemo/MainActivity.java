package com.example.user.viewpagedemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.viewpagedemo.Adapter.SliderAdapter;

public class MainActivity extends AppCompatActivity {
    private ViewPager mSliderViewPage;
    private LinearLayout mDotLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSliderViewPage=findViewById(R.id.viewpage);
        mDotLayout=findViewById(R.id.viewlin);
        sliderAdapter = new SliderAdapter(this);
        mSliderViewPage.setAdapter(sliderAdapter);
        addIndicator(0);
        mSliderViewPage.addOnPageChangeListener(viewListener);
    }
    public void addIndicator(int position){

        mDots = new TextView[3];
        mDotLayout.removeAllViews();
        for(int i = 0;i<mDots.length;i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorAccent));
            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length>0){

            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimary));

        }
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
