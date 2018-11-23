package com.example.user.firebase_google;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView main_textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.main_textview).setOnClickListener(this);/*直接取物件此用法用在無返回值*/


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_textview:
                startActivity(new Intent(MainActivity.this,SignUpActivity.class));
                break;
        }


    }
}
