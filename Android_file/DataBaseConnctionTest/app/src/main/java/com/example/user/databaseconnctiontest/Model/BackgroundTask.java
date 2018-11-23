package com.example.user.databaseconnctiontest.Model;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
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
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String,Void,String>{
    Context ctx;
    String url="http://172.20.10.2/webapp/";
    AlertDialog alertDialog;

    public BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }




    /*需要建構子，需要用就叫*/
    /*背景執行*/

    @Override
    protected void onPreExecute() {
        alertDialog=new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login information");

        super.onPreExecute();
    }




    /*Void為暫時儲存*/
    @Override
    protected String doInBackground(String... params) {
        String reg_url=url+"register.php";
        String reg_login=url+"login.php";
        String method=params[0];
        if(method.equals("register")){
            String s_name=params[1];
            String s_u_name=params[2];
            String s_u_pass=params[3];

            try {
                URL url=new URL(reg_url);/*你的網址*/
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();/*(轉型),使用網址來連接*/
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data= URLEncoder.encode("s_name","UTF-8")+"="+URLEncoder.encode(s_name,"UTF-8")+"&"+
                             URLEncoder.encode("s_u_name","UTF-8")+"="+URLEncoder.encode(s_u_name,"UTF-8")+"&"+
                             URLEncoder.encode("s_u_pass","UTF-8")+"="+URLEncoder.encode(s_u_pass,"UTF-8");
                             bufferedWriter.write(data);
                             bufferedWriter.flush();
                             bufferedWriter.close();
                             os.close();

                InputStream IS =httpURLConnection.getInputStream();
                IS.close();
                return "Registration Success..";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(method.equals("login")){
            String ed_name=params[1];
            String ed_pass=params[2];
            try {

                URL url=new URL(reg_login);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();/*(轉型),使用網址來連接*/
                httpURLConnection.setRequestMethod("POST");/*POST方法*/
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data=URLEncoder.encode("ed_name","UTF-8")+"="+URLEncoder.encode(ed_name,"UTF-8")+"&"+
                        URLEncoder.encode("ed_pass","UTF-8")+"="+URLEncoder.encode(ed_pass,"UTF-8");
                /*有開有關很重要,習慣性要關掉,如果沒關掉會佔一個por(位置)*/
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream IS =httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(IS,"UTF-8"));/*讀取裡面的值(Data)*/
                String response="";
                String line="";

                while((line=bufferedReader.readLine())!=null){/*如果讀出來不是空值*/
                    response+=line;/*如果有多筆,用壘加的方式用出來*//*保護機制,*/
                }
                bufferedReader.close();
                IS.close();
                httpURLConnection.disconnect();
                return  response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
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
        if(result.equals("Registration Success..")) {

            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }else {
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }

}
