package tw.com.lccnet.app.database_sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static tw.com.lccnet.app.database_sqlite.R.id.Register;

public class MainActivity extends AppCompatActivity {
    private Button Login,Register,Update,Delete;
    int status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login= (Button) findViewById(R.id.Login);
        Register= (Button) findViewById(R.id.Register);
        Update= (Button) findViewById(R.id.Update);
        Delete= (Button) findViewById(R.id.Delete);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status=0;
                Bundle b =new Bundle();
                b.putInt("status",status);
                Intent i =new Intent(MainActivity.this,LoginActivity.class);
                i.putExtras(b);
                startActivity(i);
                finish();
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status=1;
                Bundle b =new Bundle();
                b.putInt("status",status);
                Intent i =new Intent(MainActivity.this,RegisterActivity.class);
                i.putExtras(b);
                startActivity(i);
                finish();
            }
        });
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status=2;
                Bundle b =new Bundle();
                b.putInt("status",status);
                Intent i =new Intent(MainActivity.this,UpdateActivity.class);
                i.putExtras(b);
                startActivity(i);
                finish();
            }
        });
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status=3;
                Bundle b =new Bundle();
                b.putInt("status",status);
                Intent i =new Intent(MainActivity.this,DeleteActivity.class);
                i.putExtras(b);
                startActivity(i);
                finish();
            }
        });
    }

}
