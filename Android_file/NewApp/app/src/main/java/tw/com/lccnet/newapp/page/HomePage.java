package tw.com.lccnet.newapp.page;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.GridView;
import android.widget.TextView;

import tw.com.lccnet.newapp.base.BasePage;

public class HomePage extends BasePage {
    public HomePage(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();

        tv_title.setText("首頁");

        TextView tv=new TextView(context);
        tv.setText("主要內容");
        tv.setGravity(Gravity.CENTER);
        tv.setTextColor(Color.RED);
        tv.setTextSize(25);

        fl_context.addView(tv);


    }
}
