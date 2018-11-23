package tw.com.lccnet.subpagedemo.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tw.com.lccnet.subpagedemo.R;
import tw.com.lccnet.subpagedemo.baseFragment.BaseFragment;
import tw.com.lccnet.subpagedemo.baseFragment.BasePage;
import tw.com.lccnet.subpagedemo.page.AboutsPage;
import tw.com.lccnet.subpagedemo.page.HomePage;
import tw.com.lccnet.subpagedemo.page.NewsConPage;
import tw.com.lccnet.subpagedemo.page.ServicePage;
import tw.com.lccnet.subpagedemo.page.SettingPage;

public class ContentFragment extends BaseFragment {

    private ViewPager viewPager;
    private RadioGroup rg_main;
    private ArrayList<BasePage> basePages;

    @Override
    public View initView() {

        View view=View.inflate(context, R.layout.content_layout,null);
        viewPager=view.findViewById(R.id.VP);
        rg_main=view.findViewById(R.id.RG_group);



        return view;
    }

    @Override
    public void initData() {
        super.initData();
        basePages=new ArrayList<>();
        basePages.add(new HomePage(context));
        basePages.add(new NewsConPage(context));
        basePages.add(new ServicePage(context));
        basePages.add(new SettingPage(context));
        basePages.add(new AboutsPage(context));
        rg_main.check(R.id.rb_home);
        viewPager.setAdapter(new ContentFragmentAdapter());




    }
    class ContentFragmentAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return basePages.size();
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            BasePage basePage=basePages.get(position);/*各頁面*/
            View rootView=basePage.rootview;
            basePage.initData();
            container.addView(rootView);
            return rootView;
        }
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }
        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
           // super.destroyItem(container, position, object);要刪除,不然會指標錯誤
            container.removeView((View) object);

        }


    }
}
