package com.example.ang.myappfrigiterlogin0423.model;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String,Void,String> {
    Context ctx;
   // Activity ctx;
    AlertDialog alertDialog;
    // String url="http://192.168.1.152/webapp/";
   // String url="http://localhost/webapp/";
    //String url="http://192.168.179.2:8081/webapp/";
    String url="http://192.168.181.2/webapp/";
    public BackgroundTask(Context ctx) {
        this.ctx = ctx;
       // cctx=this.ctx;
    }

    @Override
    protected void onPreExecute() {
      //  super.onPreExecute();
       // alertDialog=new AlertDialog.Builder(ctx).create();
       // alertDialog=new AlertDialog.Builder(ctx).create();
      //  alertDialog.setTitle("Login Information");
    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url=url+"register.php";
        String login_url=url+"login.php";
        String method=params[0];
        Log.d("method",method);
        if(method.equals("register")){
            String rname=params[1];
            String rusername=params[2];
            Toast.makeText(ctx.getApplicationContext(),method,Toast.LENGTH_SHORT).show();
            //int ww=Integer.parseInt(params[2]);
            String ruserpass=params[3];
            try {
                URL url=new URL(reg_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data= URLEncoder.encode("rname","UTF-8")+"="+URLEncoder.encode(rname,"UTF-8")+"&"+
                            URLEncoder.encode("rusername","UTF-8")+"="+URLEncoder.encode(rusername,"UTF-8")+"&"+
                            URLEncoder.encode("ruserpass","UTF-8")+"="+URLEncoder.encode(ruserpass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream is=httpURLConnection.getInputStream();
                is.close();
                return "rs success";


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(method.equals("login")){
            String loginName=params[1];
            String loginPass=params[2];
            //Toast.makeText()

            try {
                URL url=new URL(login_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);//****
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data= URLEncoder.encode("loginName","UTF-8")+"="+URLEncoder.encode(loginName,"UTF-8")+"&"+
                            URLEncoder.encode("loginPass","UTF-8")+"="+URLEncoder.encode(loginPass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream is=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(is,"UTF-8"));
                String response="";
                String line="";
                while ((line=bufferedReader.readLine())!=null){
                    response+=line;
                }
                bufferedReader.close();
                is.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        // super.onPostExecute(result);
        if (ctx != null) {
            if (result.equals("rs success")) {
                // Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
                Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
            } else {
                // alertDialog.setMessage(result);
                // alertDialog.show();
                Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
                // Toast.makeText(ctx, response, Toast.LENGTH_LONG).show();
            }
        }
    }
}
