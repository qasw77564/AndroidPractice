package tw.com.lccnet.subpagedemo.page;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import tw.com.lccnet.subpagedemo.baseFragment.BasePage;

//設定主頁
public class ServicePage extends BasePage {
    public ServicePage(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        /*1.設定標題*/
        tv_title.setText("服務頁面");
        /*2.連接網路*/
        TextView textView=new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        /*3.加入頁面*/
        fl_content.addView(textView);
        /*4.綁定數據*/
        textView.setText("服務");
    }
}
