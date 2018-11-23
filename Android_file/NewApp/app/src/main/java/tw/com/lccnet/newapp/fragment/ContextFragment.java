package tw.com.lccnet.newapp.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import java.util.ArrayList;
import tw.com.lccnet.newapp.R;
import tw.com.lccnet.newapp.adapter.ContentFragmentAdapter;
import tw.com.lccnet.newapp.base.BaseFragment;
import tw.com.lccnet.newapp.base.BasePage;
import tw.com.lccnet.newapp.page.AboutPage;
import tw.com.lccnet.newapp.page.HomePage;
import tw.com.lccnet.newapp.page.NewsPage;
import tw.com.lccnet.newapp.page.ServicePage;
import tw.com.lccnet.newapp.page.SettingPage;
import tw.com.lccnet.newapp.uiview.NoScrollViewPage;

public class ContextFragment extends BaseFragment {
    private NoScrollViewPage viewpage;
    private RadioGroup rb_main;
    private ArrayList<BasePage> basePagers;

    @Override
    public View initView() {
        View view=View.inflate(context, R.layout.content_fragment,null);
        viewpage=view.findViewById(R.id.viewpage);
        rb_main=view.findViewById(R.id.rb_group);

        return view;
    }


    @Override
    public void initData() {
        super.initData();
        //初始化5個頁面
        basePagers=new ArrayList<>();
        basePagers.add(new HomePage(context));
        basePagers.add(new NewsPage(context));
        basePagers.add(new ServicePage(context));
        basePagers.add(new SettingPage(context));
        basePagers.add(new AboutPage(context));

        //設置默認首頁
        rb_main.check(R.id.rb_home);

        viewpage.setAdapter(new ContentFragmentAdapter(basePagers));
        //rb_main監聽方法
        rb_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //監聽某一個按鍵式事件被點擊(當桉建被點擊時進行下載內容)，預設下載首頁
        viewpage.addOnPageChangeListener(new MyaddOnPageChangeListener());
        //預設先下載首頁position ０basePagers.get(position).initData();
        basePagers.get(0).initData();
    }

    class MyaddOnPageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //調用被選中的頁面
            basePagers.get(position).initData();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }



    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId){
                case R.id.rb_home:
                    viewpage.setCurrentItem(0,false);
                    break;
                case R.id.rb_news:
                    viewpage.setCurrentItem(1,false);

                    break;
                case R.id.rb_service:
                    viewpage.setCurrentItem(2,false);
                    break;
                case R.id.rb_setting:
                    viewpage.setCurrentItem(3,false);
                    break;
                case R.id.rb_about:
                    viewpage.setCurrentItem(4,false);
                    break;
            }
        }
    }

}
