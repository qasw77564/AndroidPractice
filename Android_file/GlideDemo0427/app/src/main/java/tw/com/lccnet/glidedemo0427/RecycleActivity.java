package tw.com.lccnet.glidedemo0427;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import tw.com.lccnet.glidedemo0427.adapter.GlideRecycleViewAdapter;

public class RecycleActivity extends AppCompatActivity {
private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        setTitle("Recycle Glide");
        init();
    }

    private void init() {
        recyclerView=findViewById(R.id.rv_glide);
        GlideRecycleViewAdapter glideRecycleViewAdapter=new GlideRecycleViewAdapter(this);
        recyclerView.setAdapter(glideRecycleViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }
}
