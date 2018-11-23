package tw.com.lccnet.sqlitedemo;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tw.com.lccnet.sqlitedemo.db.DatabaseOperations;

public class LoginActivity extends AppCompatActivity {
    EditText login_name,login_pass;
    Button login_btn;
    String username,userpass;
    Context CTX=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_name=findViewById(R.id.login_user_xml);
        login_pass=findViewById(R.id.login_pass_xml);
        login_btn=findViewById(R.id.login_btn_xml);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               Bundle b=getIntent().getExtras();
               int status=b.getInt("status");

               if(status==1){
                   Toast.makeText(getBaseContext(),"please wait ...",Toast.LENGTH_LONG).show();
                   username =login_name.getText().toString();
                   userpass =login_pass.getText().toString();

                   DatabaseOperations DOP=new DatabaseOperations(CTX);
                   Cursor CR=DOP.getInformatio0n(DOP);
                   CR.moveToFirst();
                   boolean loginstatus=false;
                   String NAME="";
                   do{

                       if(username.equals(CR.getString(0)) && (userpass.equals(CR.getString(1)))){
                           loginstatus=true;
                           NAME=CR.getString(0);
                       }


                   }while(CR.moveToNext());

                   if(loginstatus){
                       Toast.makeText(getBaseContext(),"Login Successs--- Welcome "+NAME,Toast.LENGTH_LONG).show();
                       finish();
                   }else{
                       Toast.makeText(getBaseContext(),"Login Failed--- ",Toast.LENGTH_LONG).show();
                       finish();
                   }


               }else if(status==2){
                   Intent i=new Intent("update_filter");
                   startActivity(i);
               }else if(status==3){
                   //
                   Toast.makeText(getBaseContext(),"please wait ...",Toast.LENGTH_LONG).show();
                   username =login_name.getText().toString();
                   userpass =login_pass.getText().toString();

                   DatabaseOperations DOP=new DatabaseOperations(CTX);
                   Cursor CR=DOP.getInformatio0n(DOP);
                   CR.moveToFirst();
                   boolean loginstatus=false;
                   String NAME="";
                   do{

                       if(username.equals(CR.getString(0)) && (userpass.equals(CR.getString(1)))){
                           loginstatus=true;
                           NAME=CR.getString(0);
                       }


                   }while(CR.moveToNext());

                   if(loginstatus){
                       Toast.makeText(getBaseContext(),"Login Successs--- Welcome "+NAME,Toast.LENGTH_LONG).show();

                       Intent i=new Intent("delete_filter");
                       Bundle B=new Bundle();
                       B.putString("user_name",NAME);
                       i.putExtras(B);
                       startActivity(i);
                       finish();
                   }else{
                       Toast.makeText(getBaseContext(),"Login Failed--- ",Toast.LENGTH_LONG).show();
                       finish();
                   }




               }
            }
        });


    }
}
