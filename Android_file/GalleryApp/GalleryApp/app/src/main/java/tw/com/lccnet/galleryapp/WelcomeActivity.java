package tw.com.lccnet.galleryapp;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import org.json.JSONObject;

import tw.com.lccnet.galleryapp.bean.welcomebean;
import tw.com.lccnet.galleryapp.catchUtils.CatchUtils;
import tw.com.lccnet.galleryapp.config.Config;
import tw.com.lccnet.galleryapp.model.MySingleTon;

public class WelcomeActivity extends AppCompatActivity {
    private ImageView imageViewW;
    private TextView textViewW;
    private String path_welcome = Config.url_server + "images/logo.gif";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        imageViewW = findViewById(R.id.welcome_image);
        textViewW = findViewById(R.id.welcome_context);
        Glide.with(WelcomeActivity.this).load(path_welcome).into(imageViewW);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean isStartMain = CatchUtils.getBoolean(WelcomeActivity.this, Config.START_MAIN);
                if (isStartMain) {
                    startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                } else {
                    startActivity(new Intent(WelcomeActivity.this, GuideActivity.class));
                }
                WelcomeActivity.this.finish();
            }
        }, 3000);
    }


}
