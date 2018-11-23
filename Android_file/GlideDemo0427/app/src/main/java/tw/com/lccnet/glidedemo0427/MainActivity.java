package tw.com.lccnet.glidedemo0427;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Button bt_glide_base,btn_glide_recycle,btn_glide_tran;
Activity activity=MainActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_glide_base=findViewById(R.id.button);
        btn_glide_recycle=findViewById(R.id.button2);
        btn_glide_tran=findViewById(R.id.button3);
        init();
    }

    private void init() {
        bt_glide_base.setOnClickListener(this);
        btn_glide_recycle.setOnClickListener(this);
        btn_glide_tran.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                //Toast.makeText(this,"ok",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(activity,BaseActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(activity,RecycleActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(activity,TranActivity.class));
                break;
        }
    }
}
