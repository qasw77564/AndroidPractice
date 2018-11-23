package com.example.ang.hsiehproject0527;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ang.hsiehproject0527.task.TransTask;
import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TransTask transTask=new TransTask();/*如果直接new TransTask*/
        transTask.execute("http://app.code-edit.com/zh/welcome.json");

        try {
            String www=transTask.get();
            Toast.makeText(this,www,Toast.LENGTH_LONG).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
