package tw.com.lccnet.app.androidlifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
TextView txtclick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TAG..", "onCreate");
        txtclick= (TextView) findViewById(R.id.txta);
        txtclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TwoActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG..", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG..", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG..", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TAG..", "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG..", "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG..", "onDestroy");
    }
    public void myclick(View v){

    }
}
