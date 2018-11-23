package tw.com.lccnet.sqlitedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        Button reg_btn,log_btn,update_btn,delete_btn;
        int status=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reg_btn=findViewById(R.id.btn_register);
        reg_btn.setOnClickListener(this);

        log_btn=findViewById(R.id.btn_login);
        log_btn.setOnClickListener(this);

        update_btn=findViewById(R.id.btn_update);
        update_btn.setOnClickListener(this);

        delete_btn=findViewById(R.id.btn_delete);
        delete_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Bundle b;
        Intent i;
        switch (v.getId()){
            case R.id.btn_register:
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
                break;
            case R.id.btn_login:
                status=1;
                b=new Bundle();
                b.putInt("status",status);
                 i=new Intent(MainActivity.this,LoginActivity.class);
                i.putExtras(b);
                startActivity(i);
              break;
            case R.id.btn_update:
                status=2;
                b=new Bundle();
                b.putInt("status",status);
               i=new Intent(MainActivity.this,UpdateActivity.class);
                i.putExtras(b);
                startActivity(i);
                break;
            case R.id.btn_delete:
                status=3;
                b=new Bundle();
                b.putInt("status",status);
                i=new Intent(MainActivity.this,DeleteActivity.class);
                i.putExtras(b);
                startActivity(i);
                break;
        }
    }
}
