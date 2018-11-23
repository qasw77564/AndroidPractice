package tw.com.lccnet.glidedemo0427;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.File;

public class BaseActivity extends AppCompatActivity {
TextView tv_glide_01,tv_glide_02,tv_glide_03,tv_glide_04,tv_glide_05,tv_glide_06,tv_glide_07,tv_glide_08,tv_glide_09;
ImageView iv_glide_01, iv_glide_02,iv_glide_03,iv_glide_04,iv_glide_05,iv_glide_06,iv_glide_07,iv_glide_08,iv_glide_09;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        setTitle("基本 Glide");

        item01();
        item02();
        item03();
        item04();
        item05();
        item06();

    }


    private void item06() {
        tv_glide_06=findViewById(R.id.tv_glide_06);
        iv_glide_06=findViewById(R.id.iv_glide_06);
        tv_glide_06.setText("取得圖片");
        String urlpath=WebURL.webapp+"bmw.jpg";
        Glide.with(this).load(new File(urlpath)).thumbnail(0.1f).into(iv_glide_06);
    }

    private void item05() {
        tv_glide_05=findViewById(R.id.tv_glide_05);
        iv_glide_05=findViewById(R.id.iv_glide_05);
        tv_glide_05.setText("取得手機gif圖片");

        Glide.with(this).load(R.drawable.girl).into(iv_glide_05);
    }

    private void item04() {
        tv_glide_04=findViewById(R.id.tv_glide_04);
        iv_glide_04=findViewById(R.id.iv_glide_04);
        tv_glide_04.setText("取得gif圖片");
        String urigif="https://i.gifer.com/4LMi.gif";
        Glide.with(this).load(urigif).into(iv_glide_04);
    }

    private void item03() {
        tv_glide_03=findViewById(R.id.tv_glide_03);
        iv_glide_03=findViewById(R.id.iv_glide_03);
        tv_glide_03.setText("取得SD卡圖片");
        String path= Environment.getExternalStorageDirectory()+"/bmw.jpg";
        File file=new File(path);
        Uri uri=Uri.fromFile(file);
        Glide.with(this).load(uri).into(iv_glide_03);
    }

    private void item02() {
        tv_glide_02=findViewById(R.id.tv_glide_02);
        iv_glide_02=findViewById(R.id.iv_glide_02);
        tv_glide_02.setText("取得檔案圖片");
        Glide.with(this).load(R.drawable.egirls).into(iv_glide_02);
        // Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRENq7mHO_xH-Ado82TtYKzxP4gM-w5WZimrx3jBYVaQ06rnc1BPQ").into(iv_glide_01);
    }
    private void item01() {
        tv_glide_01=findViewById(R.id.tv_glide_01);
        iv_glide_01=findViewById(R.id.iv_glide_01);
        tv_glide_01.setText("取得網路圖片");
        Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRENq7mHO_xH-Ado82TtYKzxP4gM-w5WZimrx3jBYVaQ06rnc1BPQ").into(iv_glide_01);
       //  Glide.with(this).load(WebURL.webapp+"bmw.jpg").into(iv_glide_01);
    }
}
