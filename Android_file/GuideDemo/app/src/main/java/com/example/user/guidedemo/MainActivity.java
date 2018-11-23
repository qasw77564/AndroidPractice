package com.example.user.guidedemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.guidedemo.adapter.SliderAdaapter;

public class MainActivity extends AppCompatActivity {
    private ViewPager mSlideViewPage;
    private LinearLayout mDotLayout;
    private TextView[] mDits;
    private SliderAdaapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSlideViewPage=findViewById(R.id.viewpage);
        mDotLayout=findViewById(R.id.dots);
        adapter=new SliderAdaapter(this);
        mSlideViewPage.setAdapter(adapter);
        addDotsicater(0);
        mSlideViewPage.addOnPageChangeListener(viewpagechange);


    }
    public void addDotsicater(int position){
    mDits=new TextView[3];
    mDotLayout.removeAllViews();/*清除整個Layout*/
    for(int i=0;i<mDits.length;i++){
        mDits[i]=new TextView(this);
        mDits[i].setText(Html.fromHtml("&#8226;"));
        mDits[i].setTextColor(getResources().getColor(R.color.colorAccent));
        mDits[i].setTextSize(40);
        mDotLayout.addView(mDits[i]);
        }
        if(mDits.length>0){
            mDits[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }

    }
    ViewPager.OnPageChangeListener viewpagechange=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsicater(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
