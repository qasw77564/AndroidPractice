package tw.com.lccnet.app.androidlifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Log.i("TAG..22", "onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG..22", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG..22", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG..22", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TAG..22", "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG..22", "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG..22", "onDestroy");
    }
}
