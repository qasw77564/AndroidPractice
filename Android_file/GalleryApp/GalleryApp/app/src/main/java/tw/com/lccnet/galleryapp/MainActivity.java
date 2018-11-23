package tw.com.lccnet.galleryapp;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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

import tw.com.lccnet.galleryapp.adapter.RecyclerAdapter;
import tw.com.lccnet.galleryapp.bean.Album;
import tw.com.lccnet.galleryapp.config.Config;
import tw.com.lccnet.galleryapp.model.MySingleTon;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    List<Album> list = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private DrawerLayout drawerLayoutM;
    private ActionBarDrawerToggle actionBarDrawerToggleM;
    private NavigationView naview;
    MenuItem menuItem1, menuItem2, menuItem3, menuItem4, menuItem5;
    Menu menu_draw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addRecyclePage();
        menu_item();


    }

    private void menu_item() {

        drawerLayoutM = findViewById(R.id.drawerLayoutM);
        actionBarDrawerToggleM = new ActionBarDrawerToggle(this, drawerLayoutM, R.string.drawer_open, R.string.drawer_close);
        drawerLayoutM.addDrawerListener(actionBarDrawerToggleM);
        actionBarDrawerToggleM.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        naview = findViewById(R.id.navigationM);
        menu_draw = naview.getMenu();
        menuItem1 = menu_draw.findItem(R.id.draw_home);
        menuItem2 = menu_draw.findItem(R.id.draw_share);
        menuItem3 = menu_draw.findItem(R.id.draw_instructions);
        menuItem4 = menu_draw.findItem(R.id.draw_about);
        menuItem5 = menu_draw.findItem(R.id.draw_setting);


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

    private void addRecyclePage() {

        recyclerView = findViewById(R.id.recycleview);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, Config.url_server + "getinfo.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int count = 0;
                        while (count < response.length()) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(count);

                                list.add(new Album(jsonObject.getString("id"),
                                        jsonObject.getString("title")));
                                count++;
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter = new RecyclerAdapter(list, MainActivity.this);
                        recyclerView.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        MySingleTon.getmInstance(MainActivity.this).addToRequestQue(jsonArrayRequest);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggleM.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
