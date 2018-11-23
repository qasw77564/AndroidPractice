package tw.com.lccnet.app.projectapplication;

import android.content.ClipData;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {
    private long timeOut=1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
            }
        },timeOut);

    }
}
