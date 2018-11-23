package tw.com.lccnet.galleryapp.activity;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

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
    private Context context;
    private Toolbar toolbar;
    private List<Album> list=new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    //menu_header
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private NavigationView navigationView;
    private MenuItem menuItem1, menuItem2, menuItem3, menuItem4, menuItem5;
    private Menu menu_draw;
    private TextView nav_title,nav_text;
    private ImageView nav_images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        menu_item();
        getRecyclePage();
    }

    private void getRecyclePage() {
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
                        adapter=new RecyclerAdapter(list,MainActivity.this);
                        recyclerView.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MySingleTon.getmInstance(MainActivity.this).addToRequestQue(jsonArrayRequest);

    }

    private void menu_item() {
        /*actionbar的menu(三條槓那個)頭*/
        mDrawerLayout = findViewById(R.id.mDrawerLayout);
        navigationView = findViewById(R.id.nav);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*尾*/
        menu_draw = navigationView.getMenu();
        menuItem1 = menu_draw.findItem(R.id.draw_home);
        menuItem2 = menu_draw.findItem(R.id.draw_share);
        menuItem3 = menu_draw.findItem(R.id.draw_caption);
        menuItem4 = menu_draw.findItem(R.id.draw_about);
        menuItem5 = menu_draw.findItem(R.id.draw_setting);
        /*Volley用法頭*/
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Config.url_server + "menu_item.json", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String one = response.optString("menu1");
                String two = response.optString("menu2");
                String three = response.optString("menu3");
                String four = response.optString("menu4");
                String five = response.optString("menu5");
                menuItem1.setTitle(one);
                menuItem2.setTitle(two);
                menuItem3.setTitle(three);
                menuItem4.setTitle(four);
                menuItem5.setTitle(five);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });
        MySingleTon.getmInstance(MainActivity.this).addToRequestQue(jsonObjectRequest);
    }

    /*menu三條槓的點擊使用頭*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mActionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /*尾*/
}
