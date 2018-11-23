package tw.com.lccnet.glidedemo0427;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import tw.com.lccnet.glidedemo0427.adapter.GlideTranRecycle;

public class TranActivity extends AppCompatActivity {
RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tran);
        setTitle("轉換 Glide");
        rv=findViewById(R.id.tran_recycle);
        init();
    }

        private void init() {
        GlideTranRecycle gt=new GlideTranRecycle(this);
        rv.setAdapter(gt);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}
