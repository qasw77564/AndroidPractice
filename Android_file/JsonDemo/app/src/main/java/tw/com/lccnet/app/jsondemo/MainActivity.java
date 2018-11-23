package tw.com.lccnet.app.jsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

import tw.com.lccnet.app.jsondemo.model.MySingleton;
import tw.com.lccnet.app.jsondemo.model.RecyleAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private String server_url="http://192.168.1.145/getContacts.php";
    private RecyleAdapter recyleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        getinformation();
    }
    private void getinformation(){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder=new GsonBuilder();
                Gson gson=builder.create();
                List<Contacts> list= Arrays.asList(gson.fromJson(response,Contacts[].class));
                recyleAdapter=new RecyleAdapter(list);
                recyclerView.setAdapter(recyleAdapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MySingleton.getmInstance(this).addToRequestQueue(stringRequest);
    }

}

