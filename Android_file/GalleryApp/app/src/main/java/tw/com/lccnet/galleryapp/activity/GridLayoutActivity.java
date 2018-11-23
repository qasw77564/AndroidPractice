package tw.com.lccnet.galleryapp.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import tw.com.lccnet.galleryapp.R;
import tw.com.lccnet.galleryapp.adapter.SilderAdapter;

public class GridLayoutActivity extends AppCompatActivity {
    private ViewPager gridSlideViewPage;
    private LinearLayout gridDotLayout;
    private TextView[] gridDits;
    private SilderAdapter silderAdapter;
    private CardView cardView1,cardView2,cardView3,cardView4,cardView5,cardView6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
        gridSlideViewPage = findViewById(R.id.gridviewpager);
        gridDotLayout = findViewById(R.id.gridDits);
        silderAdapter = new SilderAdapter(this);
        gridSlideViewPage.setAdapter(silderAdapter);
        addDotsicater(0);
        gridSlideViewPage.addOnPageChangeListener(viewpagechange);
        cardview();

    }

    private void cardview() {
        cardView1=findViewById(R.id.card1);
        cardView2=findViewById(R.id.card2);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GridLayoutActivity.this,MainActivity.class));
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GridLayoutActivity.this,AnimeActivity.class));
            }
        });
    }


    public void addDotsicater(int position) {
        gridDits = new TextView[3];
        gridDotLayout.removeAllViews();/*清除整個Layout*/
        for (int i = 0; i < gridDits.length; i++) {
            gridDits[i] = new TextView(this);
            gridDits[i].setText(Html.fromHtml("&#8226;"));
            gridDits[i].setTextColor(getResources().getColor(R.color.colorAccent));
            gridDits[i].setTextSize(40);
            gridDotLayout.addView(gridDits[i]);
        }
        if (gridDits.length > 0) {
            gridDits[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }
    }

    /*-------功能介紹程式頭--------------*/
    ViewPager.OnPageChangeListener viewpagechange = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            /*顯示按鈕的頁面,如幾頁-1 就會在最後一頁 頭*/
            if (position == gridDits.length - 1) {
            }
            /*顯示尾*/
            addDotsicater(position);

        }
            @Override
            public void onPageScrollStateChanged ( int state){

            }

    };
}
    /*----------功能介紹程式尾-----------*/

