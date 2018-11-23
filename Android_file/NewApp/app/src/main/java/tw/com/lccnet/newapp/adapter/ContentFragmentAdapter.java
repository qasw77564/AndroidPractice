package tw.com.lccnet.newapp.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import tw.com.lccnet.newapp.base.BasePage;

public class ContentFragmentAdapter extends PagerAdapter {

    public final ArrayList<BasePage> basePagers;

    public ContentFragmentAdapter(ArrayList<BasePage> basePagers){
        this.basePagers=basePagers;
    }
    
    @Override
    public int getCount() {
        return basePagers.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        BasePage basePage=basePagers.get(position);  //各頁面實作(0,1,2,3,4)
        View rootview=basePage.rootView;
        //調用各頁面initData
        //basePage.initData();
        container.addView(rootview); //加入容器
        return rootview;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
