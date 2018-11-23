package tw.com.lccnet.app.jsondemo.model;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class MySingleton {
    private static MySingleton mInstance;
    private RequestQueue requestQueue;
    private static Context mctx;

    MySingleton(Context mctx){
       this.mctx=mctx;
        requestQueue=getRequestQueue();
    }
    public RequestQueue getRequestQueue(){
        if (requestQueue==null){
            requestQueue= Volley.newRequestQueue(mctx.getApplicationContext());
        }
        return requestQueue;
    }
    public static synchronized MySingleton getmInstance(Context context){
        if(mInstance==null){
            mInstance=new MySingleton(context);
        }
        return mInstance;
    }
    public <T> void addToRequestQueue(Request<T> request){

        getRequestQueue().add(request);
    }
}
