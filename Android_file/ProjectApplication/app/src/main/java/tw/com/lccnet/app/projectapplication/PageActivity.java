package tw.com.lccnet.app.projectapplication;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class PageActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        flag= (ImageView) findViewById(R.id.image_mg);
        Bundle bundle=getIntent().getExtras();
        if(bundle != null){
            toolbar.setTitle(bundle.getString("ApiName"));

        }
       /* setSupportActionBar(toolbar);//預設
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        TextView mtitle= (TextView) toolbar.findViewById(R.id.textber);
        mtitle.setText("Page");
        */
    }
}
