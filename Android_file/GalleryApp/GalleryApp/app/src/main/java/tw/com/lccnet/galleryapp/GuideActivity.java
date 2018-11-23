package tw.com.lccnet.galleryapp;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import tw.com.lccnet.galleryapp.adapter.SlideAdapter;
import tw.com.lccnet.galleryapp.catchUtils.CatchUtils;
import tw.com.lccnet.galleryapp.config.Config;

public class GuideActivity extends AppCompatActivity {
    private ViewPager mViewPage;
    private LinearLayout mDotsLayout;
    private SlideAdapter adapter;
    private TextView dot1, dot2, dot3;
    private TextView[] mDots;
    private Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        mViewPage = findViewById(R.id.guide_page);
        mDotsLayout = findViewById(R.id.dotLayout);
        dot1 = findViewById(R.id.tv_dot1);
        dot2 = findViewById(R.id.tv_dot2);
        dot3 = findViewById(R.id.tv_dot3);
        mDots = new TextView[]{dot1, dot2, dot3};
        adapter = new SlideAdapter(this);
        mViewPage.setAdapter(adapter);
        mViewPage.addOnPageChangeListener(viewPageChange);
        PageChange(0);
        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CatchUtils.setBoolean(GuideActivity.this, Config.START_MAIN);
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    public void PageChange(int position) {

        for (int i = 0; i < mDots.length; i++) {
            mDots[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }

    ViewPager.OnPageChangeListener viewPageChange = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            PageChange(position);

            if (position == mDots.length - 1) {
                btn_next.setVisibility(View.VISIBLE);
            } else {
                btn_next.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
