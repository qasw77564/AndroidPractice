package tw.com.lccnet.gridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView me1_image;
    private TextView me1_text;
    CardView  card1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getCard_view01();
    }

    public void getCard_view01(){
        me1_image=findViewById(R.id.me1_time);
        me1_text=findViewById(R.id.me1_text);
        me1_text.setText("hahahaha");
        card1=findViewById(R.id.card1);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();
            }
        });

    }


}
