package com.example.imagedemo;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleTon {
    /*單率設計模式 volley */
    private static MySingleTon mInstance;
    private Context ctx;
    private RequestQueue requestQueue;
    /*建構子(單例) 不給使用new 方式重新建立一個class結構,簡單說就是我只能new class 這個class共用 */
    private MySingleTon(Context ctx){
        this.ctx=ctx;
        requestQueue=getRequestQueue();
    }
    /*當requestQueue 如果為空才建立 volley的 RequestQueue (如果VOLLEY已經建立就不再建立)*/
    private RequestQueue getRequestQueue() {
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    /* 使用了一個同步鎖,部會抓取到重複值*/
    public static synchronized  MySingleTon getmInstance(Context context){
        if(mInstance==null){
            mInstance=new MySingleTon(context);
        }
        return mInstance;
    }
    /*
    自訂泛型 建立泛型內的同一種型態
     */
    public <T>void addToRequestQue(Request<T> request){
        getRequestQueue().add(request);
    }

}
