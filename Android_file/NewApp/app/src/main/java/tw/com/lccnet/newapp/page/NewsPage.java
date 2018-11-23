package tw.com.lccnet.newapp.page;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import tw.com.lccnet.newapp.base.BasePage;

public class NewsPage extends BasePage {

    public NewsPage(Context context) {
        super(context);
    }
    @Override
    public void initData() {
        super.initData();

        tv_title.setText("新聞");

        TextView tv=new TextView(context);
        tv.setText("新聞內容");
        tv.setGravity(Gravity.CENTER);
        tv.setTextColor(Color.RED);
        tv.setTextSize(25);

        ib_menu.setVisibility(View.VISIBLE);

        fl_context.addView(tv);

        ib_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"ahahahahahhah",Toast.LENGTH_LONG).show();
            }
        });
    }


}
