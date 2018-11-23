package com.example.user.volleydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    Button button_server;
    TextView textView_server;
    String server_url="https://www.mobile01.com/topicdetail.php?f=588&t=5475982";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_server=findViewById(R.id.btn_server);
        textView_server=findViewById(R.id.textserver);
        //Demo方法
        //getDemo01();

        //-----**Cache(快取)----------//*Dir切一塊fire(資料夾)*/
        Cache cache=new DiskBasedCache(getCacheDir(),1024*1024);
        Network network=new BasicNetwork(new HurlStack());
        requestQueue=new RequestQueue(cache,network);
        requestQueue.start();

        button_server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest=new StringRequest(Request.Method.POST, server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                textView_server.setText(response);
                                requestQueue.stop();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView_server.setText("Error");
                        error.printStackTrace();
                        requestQueue.stop();


                    }
                });
                requestQueue.add(stringRequest);
            }
        });


    }




    public void getDemo01(){/*無快取方法*/
        button_server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);/*新建立一個連線*/
                StringRequest stringRequest=new StringRequest(Request.Method.POST, server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                textView_server.setText(response);
                                requestQueue.stop();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView_server.setText("Error");
                        error.printStackTrace();
                        requestQueue.stop();
                    }
                });
                requestQueue.add(stringRequest);


            }
        });
    }
}
