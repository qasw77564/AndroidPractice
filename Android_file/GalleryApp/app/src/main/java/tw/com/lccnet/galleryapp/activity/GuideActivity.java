package tw.com.lccnet.galleryapp.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import tw.com.lccnet.galleryapp.R;
import tw.com.lccnet.galleryapp.adapter.SilderAdapter;

public class GuideActivity extends AppCompatActivity {
    private ViewPager mSlideViewPage;
    private LinearLayout mDotLayout;
    private TextView[] mDits;
    private SilderAdapter silderAdapter;
    private Button button_t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        /*--功能介紹---*/
        button_t=findViewById(R.id.button);
        mSlideViewPage=findViewById(R.id.viewpage);
        mDotLayout=findViewById(R.id.dots);
        silderAdapter=new SilderAdapter(this);
        mSlideViewPage.setAdapter(silderAdapter);
        addDotsicater(0);
        mSlideViewPage.addOnPageChangeListener(viewpagechange);
        /*---圖片---*/

    }
    /*----------介紹頁面下面三個點頭----------*/
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
        /*----------介紹頁面下面三個點尾----------*/
    }
    /*-------功能介紹程式頭--------------*/
    ViewPager.OnPageChangeListener viewpagechange=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            /*顯示按鈕的頁面,如幾頁-1 就會在最後一頁 頭*/
            if(position==mDits.length-1){
                button_t.setVisibility(View.VISIBLE);
                button_t.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /*引導頁面看過之後就不再進頭*/
                    //    CatchUtils.setBoolean(GuideActivity.this, Config.START_MAIN);
                        startActivity(new Intent(GuideActivity.this,GridLayoutActivity.class));
                        finish();
                        /*引導尾*/
                    }
                });
            }else {
                button_t.setVisibility(View.GONE);
            }
            /*顯示尾*/
            addDotsicater(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    /*----------功能介紹程式尾-----------*/
}
