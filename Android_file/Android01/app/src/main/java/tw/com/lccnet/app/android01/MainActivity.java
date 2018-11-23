package tw.com.lccnet.app.android01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText n1,n2;
    private Button bt,btt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1= (EditText) findViewById(R.id.nb1);

        n2= (EditText) findViewById(R.id.nb2);

        bt= (Button) findViewById(R.id.bt1);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nn1=Integer.parseInt(n1.getText().toString());
                int nn2=Integer.parseInt(n2.getText().toString());
                Toast.makeText(MainActivity.this,"計算結果："+(nn1+nn2)+"元",Toast.LENGTH_LONG).show();
            }
        });

        btt= (Button) findViewById(R.id.bt2);
        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SocActivity.class);
                startActivity(i);
            }
        });
    }
}
