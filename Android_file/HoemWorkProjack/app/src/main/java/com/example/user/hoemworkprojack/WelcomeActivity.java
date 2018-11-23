package com.example.user.hoemworkprojack;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.user.hoemworkprojack.bean.WelcomeBean;
import com.example.user.hoemworkprojack.model.GlideAll;
import com.example.user.hoemworkprojack.task.TransTask;
import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

public class WelcomeActivity extends AppCompatActivity {
    TextView t_title,t_show;
    ImageView t_imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        t_title=findViewById(R.id.m_title);
        t_show=findViewById(R.id.m_show);
        t_imageView=findViewById(R.id.m_image);
        TransTask transTask=new TransTask();
        transTask.execute("http://app.code-edit.com/zh/welcome.json");

        try {

            String json=transTask.get();
            //2.解析數據
            Gson gson=new Gson();
            WelcomeBean welcomeBean= gson.fromJson(json,WelcomeBean.class);
            //3.顯示數據
            t_title.setText(welcomeBean.getTitle().toString());
            t_show.setText(welcomeBean.getContent().toString());
            new GlideAll(this).setMask(welcomeBean.getImages(),t_imageView);

         //   Glide.with(this).load(welcomeBean.getImages()).into(t_imageView);
         /*   t_title.setText(json);
            t_show.setText(welcomeBean.toString());*/

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
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                finish();
            }
        },3000);


    }




}
