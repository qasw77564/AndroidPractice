package com.example.user.databaseconnction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    Button re_btn;
    EditText r_reg,r_name,r_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        r_reg=findViewById(R.id.r_reg);
        r_name=findViewById(R.id.r_name);
        r_pass=findViewById(R.id.r_pass);
        re_btn=findViewById(R.id.r_btn);
    }
    public void r_btn(){

    }
}
