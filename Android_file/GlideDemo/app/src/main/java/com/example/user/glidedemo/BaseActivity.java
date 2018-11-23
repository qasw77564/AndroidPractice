package com.example.user.glidedemo;


import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.File;

public class BaseActivity extends AppCompatActivity {
    private TextView tv_glide_01,tv_glide_02,tv_glide_03,tv_glide_04,tv_glide_05,tv_glide_06,tv_glide_07,tv_glide_08,tv_glide_09;
    private ImageView iv_glide_01,iv_glide_02,iv_glide_03,iv_glide_04,iv_glide_05,iv_glide_06,iv_glide_07,iv_glide_08,iv_glide_09;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        setTitle("基本使用");
        item01();  //因為方法在裡面直接呼叫了,所以元件也有初始化
        item02();
        item03();
        item04();
        item05();
        item06();

    }



    private void item01() {
        tv_glide_01=findViewById(R.id.tv_glide_1);
        iv_glide_01=findViewById(R.id.iv_glide_1);
        tv_glide_01.setText("取得網路圖片");
        Glide.with(this).load(WebURL.webapp+"/image/cake.jpg").into(iv_glide_01);
    }
    private void item02() {
        tv_glide_02=findViewById(R.id.tv_glide_2);
        iv_glide_02=findViewById(R.id.iv_glide_2);
        tv_glide_02.setText("取得android(檔案)圖片");
        Glide.with(this).load(R.drawable.cake2).into(iv_glide_02);
    }
    private void item03() {
        tv_glide_03=findViewById(R.id.tv_glide_3);
        iv_glide_03=findViewById(R.id.iv_glide_3);
        tv_glide_03.setText("取得SD卡內圖片");
        String path= Environment.getExternalStorageDirectory()+"/cake.jpg";
        File file=new File(path);
        Uri uri=Uri.fromFile(file);

        Glide.with(this).load(uri).into(iv_glide_03);
    }
    private void item04() {
        tv_glide_04=findViewById(R.id.tv_glide_4);
        iv_glide_04=findViewById(R.id.iv_glide_4);
        tv_glide_04.setText("取得網路GIF圖片");
        String gifUrl="https://mmbiz.qpic.cn/mmbiz/aibZRaibYJzwhC5ciaUa6iclvu6UCjibDfEoa17vswuZNHeRwEVKFZbXfO3CjquLIeMLT2nZomkXr9vYQzCz1KllHfA/640?wx_fmt=gif&_ot=1523491200080";


        Glide.with(this).load(gifUrl).into(iv_glide_04);
    }
    private void item05() {
        tv_glide_05=findViewById(R.id.tv_glide_5);
        iv_glide_05=findViewById(R.id.iv_glide_5);
        tv_glide_05.setText("取得android內的gif(檔案)圖片");
        Glide.with(this).load(R.drawable.rice).into(iv_glide_05);
    }

    private void item06() {
        tv_glide_06=findViewById(R.id.tv_glide_6);
        iv_glide_06=findViewById(R.id.iv_glide_6);
        tv_glide_06.setText("取得圖片");
        String urlpath=WebURL.webapp+"/image/cake.jpg";/*位置*/
        Glide.with(this).load(new File(urlpath)).thumbnail(0.1f).into(iv_glide_06);

    }

}
