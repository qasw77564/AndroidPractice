package com.example.user.databaseconnction;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class WelcomeActivity extends AppCompatActivity {

    private ImageView iv_glide_01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        /**
         * 隱藏 navigationBar
         */
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
        item01();

    }

    private void item01() {
        iv_glide_01=findViewById(R.id.iv_glide_1);
        String gifUrl="http://172.20.10.2/webapp/image/rice.gif";
        Glide.with(this).load(gifUrl).into(iv_glide_01);
    }
}
