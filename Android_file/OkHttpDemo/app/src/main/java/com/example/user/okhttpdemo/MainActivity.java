package com.example.user.okhttpdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {/*本身就包含Click事件*/
    private static final int GET=1;
    private static final int POST=2;
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private Button btn_get,btn_post;
    private TextView tv_show;
    private OkHttpClient client = new OkHttpClient();
    private Handler handler=new Handler(){/*透過handler去執行緒取得值*/
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case GET:
                    String k= (String) msg.obj;
                    tv_show.setText((String) msg.obj);
                    break;

                case POST:
                    tv_show.setText((String) msg.obj);
                    break;

            }
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_get=findViewById(R.id.btn_get);//原生(原本公司就用的)
        btn_post=findViewById(R.id.btn_post);
        tv_show=findViewById(R.id.tv_result);
        btn_get.setOnClickListener(this);
        btn_post.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_get:  //get and post網路數據請求
                getDataFromGet();
            break;
            case R.id.btn_post:
                getDataFromPost();
                break;

        }
    }
    /*使用POST請求網路數據*/
    public void getDataFromPost() {
        new Thread() {
            @Override
            public void run() {
                try {
                    String result = postURL("http://172.20.10.2/webapp/getjson.php", "");
                    Log.i("TAG", result);
                    Message msg = Message.obtain();
                    msg.what = POST;
                    msg.obj = result;
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }




    /*使用GET請求網路數據*/
    public void getDataFromGet(){
        new Thread(){
            @Override
            public void run() {
                try {
                    String result = getUrl("http://172.20.10.2/webapp/getjson.php");
                    Log.i("TAG",result);
                    Message msg=Message.obtain();
                    msg.what=GET;
                    msg.obj=result;
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
    /**
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */

    String postURL(String url, String json) throws IOException {
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        }

    /**
     *
     * @param url
     * @return
     * @throws IOException
     */

        private String getUrl(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }


}
