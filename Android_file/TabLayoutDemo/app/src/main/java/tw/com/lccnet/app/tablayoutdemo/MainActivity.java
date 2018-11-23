package tw.com.lccnet.app.tablayoutdemo;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tw.com.lccnet.app.tablayoutdemo.fragment.Fragment1;
import tw.com.lccnet.app.tablayoutdemo.fragment.Fragment2;
import tw.com.lccnet.app.tablayoutdemo.fragment.Fragment3;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager= (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomerAdapter(getSupportFragmentManager(),getApplicationContext()));
        tabLayout= (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            viewPager.setCurrentItem(tab.getPosition());
            }
        });
    }

    private class CustomerAdapter extends FragmentPagerAdapter {
        private String[] fragment=getResources().getStringArray(R.array.fragmentTitle);
        public CustomerAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new Fragment1();
                case 1:
                    return new Fragment2();
                case 2:
                    return new Fragment3();
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return fragment.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragment[position];
        }
    }
}
