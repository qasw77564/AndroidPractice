package com.example.user.databaseconnctiontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.databaseconnctiontest.Model.BackgroundTask;

public class Register extends AppCompatActivity {
    Button re_btn;
    EditText r_regname,r_named,r_passd;

    String s_name,s_u_name,s_u_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        r_regname=findViewById(R.id.r_regname);

        r_named=findViewById(R.id.r_named);
        r_passd=findViewById(R.id.r_passd);
        re_btn=findViewById(R.id.re_btn);

        }

    public void R_register(View view){
        s_name=r_regname.getText().toString().trim();
        s_u_name=r_named.getText().toString().trim();
        s_u_pass=r_passd.getText().toString().trim();
        String method="register";/*做比對*/
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute(method,s_name,s_u_name,s_u_pass);
        finish();
        }
    }
