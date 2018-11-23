package tw.com.lccnet.app.database_sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText input1,input2;
    private Button Login;
    private String name,passwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        input1= (EditText) findViewById(R.id.editText);
        input2= (EditText) findViewById(R.id.editText2);
        Login= (Button) findViewById(R.id.Login);
        name=input1.getText().toString();
        passwd=input2.getText().toString();
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
