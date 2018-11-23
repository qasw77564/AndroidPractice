package tw.com.lccnet.galleryapp.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import tw.com.lccnet.galleryapp.R;
import tw.com.lccnet.galleryapp.config.Config;

public class AnimeClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_click);
        animeString();
    }

    private void animeString() {
        //Recieve data
        String name=getIntent().getExtras().getString("anime_name");
        String description=getIntent().getExtras().getString("anime_description");
        String studio=getIntent().getExtras().getString("anime_studio");
        String category=getIntent().getExtras().getString("anime_category");
        int nb_episode=getIntent().getExtras().getInt("anime_nb_episode");
        String image_url=getIntent().getExtras().getString("anime_img");
        String rating=getIntent().getExtras().getString("anime_rating");
        // ini views
        CollapsingToolbarLayout collapsingToolbarLayout=findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name=findViewById(R.id.a_anime_name);
        TextView tv_studio=findViewById(R.id.a_studio);
        TextView tv_categorie=findViewById(R.id.a_categorie);
        TextView tv_description=findViewById(R.id.a_description);
        TextView tv_rating=findViewById(R.id.a_rating);
        ImageView img=findViewById(R.id.a_thumbnail);

        //setting values to each view
        tv_name.setText(name);
        tv_categorie.setText(category);
        tv_description.setText(description);
        tv_rating.setText(rating);
        tv_studio.setText(studio);


        collapsingToolbarLayout.setTitle(name);

        RequestOptions requestOptions=new RequestOptions().centerCrop().placeholder(R.drawable.loding_shape).error(R.drawable.loding_shape);

        //set image using Glide
        Glide.with(this).load(image_url).apply(requestOptions).into(img);
    }
}
