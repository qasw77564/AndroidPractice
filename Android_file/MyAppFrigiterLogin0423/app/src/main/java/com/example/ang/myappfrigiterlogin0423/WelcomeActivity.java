package com.example.ang.myappfrigiterlogin0423;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {
ImageView iv;
Animation at;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        /**
         * 隱藏 navigationBar
         */
        iv=(ImageView)findViewById(R.id.imageView);
        at= AnimationUtils.loadAnimation(getBaseContext(),R.anim.alpha_in);
        iv.setAnimation(at);
        iv.setImageResource(R.drawable.bannerbg);
        iv.startAnimation(at);
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
