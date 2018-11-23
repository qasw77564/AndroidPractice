package tw.com.lccnet.galleryapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import tw.com.lccnet.galleryapp.R;

public class ItemActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView imageView;
    TextView textView;
    String title,path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        imageView=findViewById(R.id.imageView_item);
        textView=findViewById(R.id.textView);

        Intent i=getIntent();
        Bundle db=i.getExtras();
        if(db !=null){
            title=db.getString("title");
            path=db.getString("url");
            textView.setText(title);
            setTitle(title);
            Glide.with(this).load(path).into(imageView);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case android.R.id.home:
                onBackPressed();
                this.finish();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

}
