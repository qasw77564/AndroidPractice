package tw.com.lccnet.galleryapp.back;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import tw.com.lccnet.galleryapp.R;
import tw.com.lccnet.galleryapp.adapter.RecyclerAdapter;
import tw.com.lccnet.galleryapp.bean.Album;
import tw.com.lccnet.galleryapp.config.Config;
import tw.com.lccnet.galleryapp.model.MySingleTon;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    List<Album> list=new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView=findViewById(R.id.recycleview);
        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
                                                                                       /*url_server+"getinfo.php"*/
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.POST, Config.url_server+"getinfo.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                            int count=0;
                            while(count<response.length()){
                                try {
                                    JSONObject jsonObject=response.getJSONObject(count);

                                    list.add(new Album(jsonObject.getString("id"),
                                            jsonObject.getString("title")));
                                    count++;
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            adapter=new RecyclerAdapter(list, MainActivity.this);
                            recyclerView.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        MySingleTon.getmInstance(MainActivity.this).addToRequestQue(jsonArrayRequest);



    }

}
