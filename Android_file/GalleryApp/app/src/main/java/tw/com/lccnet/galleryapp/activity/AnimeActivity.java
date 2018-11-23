package tw.com.lccnet.galleryapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import tw.com.lccnet.galleryapp.R;
import tw.com.lccnet.galleryapp.adapter.AnimeAdapter;
import tw.com.lccnet.galleryapp.config.Config;
import tw.com.lccnet.galleryapp.bean.Anime;

public class AnimeActivity extends AppCompatActivity {
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Anime> animeList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);

        anime();

    }

    private void anime() {
        recyclerView=findViewById(R.id.recycle_anime);
        animeList=new ArrayList<>();
        request=new JsonArrayRequest(Config.anime_url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject=null;
                for(int i=0;i<response.length();i++){
                    try {
                        jsonObject=response.getJSONObject(i);
                        Anime anime=new Anime();
                        anime.setName(jsonObject.getString("name"));
                        anime.setDescription(jsonObject.getString("description"));
                        anime.setRating(jsonObject.getString("Rating"));
                        anime.setCategorie(jsonObject.getString("categorie"));
                        anime.setNb_episode(jsonObject.getInt("episode"));
                        anime.setStudio(jsonObject.getString("studio"));
                        anime.setImages_url(jsonObject.getString("img"));
                        animeList.add(anime);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                setuprecycleview(animeList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue= Volley.newRequestQueue(AnimeActivity.this);
        requestQueue.add(request);
    }

    private void setuprecycleview(List<Anime> animeList) {
        AnimeAdapter animeAdapter=new AnimeAdapter(this,animeList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(animeAdapter);
    }
}
