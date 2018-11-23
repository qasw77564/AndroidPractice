package tw.com.lccnet.app.database_sqlite;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tw.com.lccnet.app.database_sqlite.model.TableDateOperation;

public class RegisterActivity extends AppCompatActivity {
    EditText USER_NAME,USER_PASS,CON_PASS;
    Button REG;
    String user_name,user_pass,con_pass;
    Context ctx=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        USER_NAME= (EditText) findViewById(R.id.register_name);
        USER_PASS= (EditText) findViewById(R.id.register_pass);
        CON_PASS= (EditText) findViewById(R.id.register_con);
        REG= (Button) findViewById(R.id.button);
        REG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_name=USER_NAME.getText().toString();
                user_pass=USER_PASS.getText().toString();
                con_pass=CON_PASS.getText().toString();
                if(!user_pass.equals(con_pass)){
                    Toast.makeText(getBaseContext(),"密碼不正確",Toast.LENGTH_LONG).show();
                    USER_NAME.setText("");
                    USER_PASS.setText("");
                    CON_PASS.setText("");
                }else{
                    TableDateOperation DB=new TableDateOperation(ctx);
                    DB.putInformation(DB,user_name,user_pass);
                    Toast.makeText(getBaseContext(),"登錄資料成功",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
