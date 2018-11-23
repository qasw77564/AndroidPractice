package com.example.user.galleryprojeck.model;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleTon {
    private static MySingleTon mInstance;
    private Context ctx;
    private RequestQueue requestQueue;

    public MySingleTon(Context ctx) {
        this.ctx = ctx;

    }
    private RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }
    public static synchronized MySingleTon getmInstance(Context context){
        if(mInstance==null){
            mInstance=new MySingleTon(context);
        }
        return mInstance;
    }
    public <T>void addToRequestQue(Request<T> request){
        getRequestQueue().add(request);
    }
}

