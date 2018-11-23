package com.example.user.databaseconnctiontest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.databaseconnctiontest.Model.BackgroundTask;

public class MainActivity extends AppCompatActivity {
    Button log,res;
    EditText m_register,m_name,m_pass;
    String ed_name,ed_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log=findViewById(R.id.m_lo_btn);
        res=findViewById(R.id.m_re_btn);
        m_register=findViewById(R.id.m_register);
        m_name=findViewById(R.id.m_name);
        m_pass=findViewById(R.id.m_pass);



    }

    public void M_login(View view){         /*↓去除空白值*/
        ed_name=m_name.getText().toString().trim();
        ed_pass=m_pass.getText().toString().trim();
        String method="login";
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute(method,ed_name,ed_pass);



    }
    public void M_register(View view){
        startActivity(new Intent(MainActivity.this,Register.class));
    }

}
