package com.example.user.glidedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.glidedemo.adapter.GlideTranAdapter;

public class TranformationActivity extends AppCompatActivity {
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tranformation);
        setTitle("變換圖片Glide");
        rv=findViewById(R.id.recycleview_tran);
        init();



    }

    private void init() {
        GlideTranAdapter gt=new GlideTranAdapter(this);
        rv.setAdapter(gt);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }
}
