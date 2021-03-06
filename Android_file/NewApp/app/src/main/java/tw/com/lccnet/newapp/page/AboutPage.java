package tw.com.lccnet.newapp.page;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import tw.com.lccnet.newapp.base.BasePage;

public class AboutPage extends BasePage {
    public AboutPage(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();

        tv_title.setText("關於");

        TextView tv=new TextView(context);
        tv.setText("關於內容");
        tv.setGravity(Gravity.CENTER);
        tv.setTextColor(Color.RED);
        tv.setTextSize(25);

        fl_context.addView(tv);


    }
}
