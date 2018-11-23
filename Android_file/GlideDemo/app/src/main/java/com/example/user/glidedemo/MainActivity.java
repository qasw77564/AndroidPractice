package com.example.user.glidedemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Button bt_glide_base,bt_glide_recycle,bt_glide_tranformation;
Activity activity=MainActivity.this;//能做物件的就做  //.this就是反射

    /*
    *
    * Glide   圖片框架
    *
    *
    *
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_glide_base=findViewById(R.id.bt_glide_base);
        bt_glide_recycle=findViewById(R.id.bt_glide_recycle);
        bt_glide_tranformation=findViewById(R.id.bt_glide_tranformation);
        init();

    }
    public void init(){
        bt_glide_base.setOnClickListener(this);
        bt_glide_recycle.setOnClickListener(this);
        bt_glide_tranformation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bt_glide_base:
                startActivity(new Intent(activity,BaseActivity.class));
                //Log.i("TAG","onclick");  //測試是否沒錯誤，可正常執行
                break;
            case R.id.bt_glide_recycle:
                startActivity(new Intent(activity,RecycleActivity.class));
                break;
            case R.id.bt_glide_tranformation:
                startActivity(new Intent(activity,TranformationActivity.class));
                break;

        }
    }
}
