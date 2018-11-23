package tw.com.lccnet.newapp.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import tw.com.lccnet.newapp.R;

public class BasePage {
    //完全自訂Fragment
    public final Context context;
    //初始化view 結構(代表不同的子頁面)
    public View rootView;
    //標題
    public TextView tv_title;
    //menu 按鍵
    public ImageButton ib_menu;
    //加入各FragmentLayout
    public FrameLayout fl_context;

    //建構子(傳入內容)
    public BasePage(Context context) {
        this.context=context;
        rootView=initView();
    }

    //載入公用元件
    public View initView(){
        View view=View.inflate(context, R.layout.base_page,null);
        tv_title=view.findViewById(R.id.tv_title);
        ib_menu=view.findViewById(R.id.ib_menu);
        fl_context=view.findViewById(R.id.fl_context);
        return view;
    }
    //初始化數據
    public void  initData(){

    }

}
