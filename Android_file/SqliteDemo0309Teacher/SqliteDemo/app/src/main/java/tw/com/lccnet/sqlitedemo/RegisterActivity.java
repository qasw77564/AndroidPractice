package tw.com.lccnet.sqlitedemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tw.com.lccnet.sqlitedemo.db.DatabaseOperations;

public class RegisterActivity extends AppCompatActivity {
    //宣告元件
    private EditText  reg_user,reg_pass,reg_conf;
    private String user_name,user_pass,conf_pass;
    private Button reg_btn;
    Context ctx=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //取得元件
        reg_user=findViewById(R.id.reg_user_xml);
        reg_pass=findViewById(R.id.reg_pass);
        reg_conf=findViewById(R.id.conf_reg_pass);
        reg_btn=findViewById(R.id.btn_user_reg);
        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_name=reg_user.getText().toString();
                user_pass=reg_pass.getText().toString();
                conf_pass=reg_conf.getText().toString();

                if(!(user_pass.equals(conf_pass))){
                    Toast.makeText(RegisterActivity.this,"Passwords are not matching",Toast.LENGTH_LONG).show();
                    reg_user.setText("");
                    reg_pass.setText("");
                    reg_conf.setText("");
                }else{
                    DatabaseOperations db=new DatabaseOperations(ctx);
                    db.putInformation(db,user_name,user_pass);
                    Toast.makeText(getBaseContext(),"Registration success",Toast.LENGTH_LONG).show();
                    finish();
                }

            }
        });
    }


}
