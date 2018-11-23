package com.example.user.glidedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.glidedemo.adapter.GlideRecycleViewAdapter;

public class RecycleActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        setTitle("RecycleView Gilde");
        init();
    }

    private void init() {
        recyclerView=findViewById(R.id.rv_glide);
        GlideRecycleViewAdapter glideRecycleViewAdapter=new GlideRecycleViewAdapter(this);
        recyclerView.setAdapter(glideRecycleViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }
}
