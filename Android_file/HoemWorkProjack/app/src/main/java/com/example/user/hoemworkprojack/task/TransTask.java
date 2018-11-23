package com.example.user.hoemworkprojack.task;

import android.os.AsyncTask;
import android.util.Log;

import com.example.user.hoemworkprojack.bean.WelcomeBean;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class TransTask extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String... params) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(params[0]);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String line = in.readLine();
            while(line!=null){
                Log.d("HTTP", line);
                sb.append(line);
                line = in.readLine();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d("JSON", s);
    }

}
