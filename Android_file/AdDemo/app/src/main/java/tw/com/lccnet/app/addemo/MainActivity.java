package tw.com.lccnet.app.addemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        private ViewFlipper vf;
        private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vf = (ViewFlipper) findViewById(R.id.viewflipper);
        vf.startFlipping();
        iv= (ImageView) findViewById(R.id.imageView);

        iv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(),TwoActivity.class));

    }
}
