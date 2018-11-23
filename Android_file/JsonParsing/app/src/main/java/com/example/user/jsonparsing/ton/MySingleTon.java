package com.example.user.jsonparsing.ton;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleTon {
    private static MySingleTon mInstance;
    private RequestQueue requestQueue;
    private Context mCtx;

    private MySingleTon(Context context){
        mCtx=context;
        requestQueue=getRequestQueue();
    }

    private RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return  requestQueue;
    }
}
