package tw.com.lccnet.app.progressbar;


import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
private ImageView img_pic;
    private AnimationDrawable ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_pic= (ImageView) findViewById(R.id.imageView);
        ad= (AnimationDrawable) img_pic.getDrawable();
        img_pic.postDelayed(new Runnable() {
            @Override
            public void run() {
                ad.start();
            }
        },100);
    }
}
