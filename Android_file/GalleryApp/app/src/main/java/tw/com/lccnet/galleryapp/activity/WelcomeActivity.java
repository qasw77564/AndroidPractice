package tw.com.lccnet.galleryapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

import tw.com.lccnet.galleryapp.R;
import tw.com.lccnet.galleryapp.bean.WelcomeBean;
import tw.com.lccnet.galleryapp.catchUtils.CatchUtils;
import tw.com.lccnet.galleryapp.config.Config;
import tw.com.lccnet.galleryapp.model.GlideAll;
import tw.com.lccnet.galleryapp.model.TransTask;

public class WelcomeActivity extends AppCompatActivity {
    TextView t_title,t_show;
    ImageView t_imageView;
    Context context;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        t_title=findViewById(R.id.m_title);
        t_show=findViewById(R.id.m_show);
        t_imageView=findViewById(R.id.m_image);
/*
       JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Config.url_server + "welcome.json", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });

*/
       TransTask transTask=new TransTask();
        transTask.execute("http://app.code-edit.com/zh/welcome.json");
        try {
            //可以試著打成jar檔
            String json=transTask.get();
            //2.解析數據
            Gson gson=new Gson();
            WelcomeBean welcomeBean= gson.fromJson(json,WelcomeBean.class);
            //3.顯示數據
            t_title.setText(welcomeBean.getTitle().toString());
            t_show.setText(welcomeBean.getContent().toString());
            new GlideAll(this).setMask(welcomeBean.getImages(),t_imageView);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        /**
         *
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean isStartMain= CatchUtils.getBoolean(WelcomeActivity.this, Config.START_MAIN);
                if(isStartMain){
                    startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                }else{
                    startActivity(new Intent(WelcomeActivity.this,GuideActivity.class));
                }
                WelcomeActivity.this.finish();

            }
        },3000);

    }
}
