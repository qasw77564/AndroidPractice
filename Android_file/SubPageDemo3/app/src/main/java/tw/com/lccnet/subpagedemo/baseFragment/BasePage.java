package tw.com.lccnet.subpagedemo.baseFragment;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import tw.com.lccnet.subpagedemo.R;

public class BasePage {
    /*
        Fragment基本類
        home,news,service,setting,about
     */

        /*
        子類會被用到
         */
        public Context context;
        /*
        返回一個圖面
         */
        public View rootview;
        public TextView tv_title;
        public ImageButton ib_menu;
        public FrameLayout fl_content;

        public BasePage(Context context) {
            this.context = context;
            rootview=initView();
        }
        public View initView(){
            View view=View.inflate(context, R.layout.base_layout,null);
            tv_title=view.findViewById(R.id.base_page_title);
            ib_menu=view.findViewById(R.id.base_images_buttom);
            fl_content=view.findViewById(R.id.base_fragment);
            return null;
        }
        public void initData(){

        }
}
