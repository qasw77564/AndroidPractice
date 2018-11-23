package tw.com.lccnet.sqlitedemo;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tw.com.lccnet.sqlitedemo.db.DatabaseOperations;

public class DeleteActivity extends AppCompatActivity {
    Bundle bn;
    String USERNAME;
    Button del;
    EditText PASS;
    String Pass;
    Context ctx;
    DatabaseOperations DOP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        del=findViewById(R.id.delete_account);
        PASS=findViewById(R.id.delete_password);
        bn=getIntent().getExtras();
        USERNAME=bn.getString("user_name");
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Pass=PASS.getText().toString();
            DOP=new DatabaseOperations(ctx);
                Cursor CR=DOP.getUserPass(DOP,USERNAME);
                CR.moveToFirst();
                boolean login_status=false;
                do{
                    if(Pass.equals(CR.getString(0))){
                        login_status=true;
                    }
                }while (CR.moveToNext());
                if(login_status){
                    DOP.deleteUser(DOP,USERNAME,Pass);
                    Toast.makeText(getBaseContext()," delete success ",Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(getBaseContext()," Invild ",Toast.LENGTH_LONG).show();
                    finish();
                }



            }
        });
    }
}
