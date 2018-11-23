package com.example.user.firebase_google;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    EditText sign_name,sign_pass;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        findViewById(R.id.main_btn).setOnClickListener(this);
        sign_name=findViewById(R.id.user_email);
        sign_pass=findViewById(R.id.user_pass);
        mAuth = FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressbar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_btn:
                registerUser();
                break;
            case R.id.main_textview:

                break;
        }

    }

    private void registerUser() {
        String useremail=sign_name.getText().toString().trim();
        String userpass=sign_pass.getText().toString().trim();
        /*這四段一定要寫*/
        if(useremail.isEmpty()){    /*isEmpty 不可空值*/
           sign_name.setError("Email can't Empty");/*注意,這裡是用元件*/
            sign_name.requestFocus();/*顯示內容*/  /*基本上是寫在一起*/
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(useremail).matches()){ /*檢查輸入的是否email格式*/
            sign_name.setError("請查看email格式,看");
            sign_name.requestFocus();
            return;
        }

        if(userpass.isEmpty()){    /*isEmpty 不可空值*/
            sign_pass.setError("pass can't Empty");/*注意,這裡是用元件*/
            sign_pass.requestFocus();/*顯示內容*/  /*基本上是寫在一起*/
            return;
        }
        if(userpass.length()<=3){    /*isEmpty 不可空值*/
            sign_pass.setError("請檢察密碼長度");/*注意,這裡是用元件*/
            sign_pass.requestFocus();/*顯示內容*/  /*基本上是寫在一起*/
            return;
        }


        progressBar.setVisibility(View.VISIBLE);/*原本隱藏的,跑到這邊就出現*/ /*progressbar的用途*/



        mAuth.createUserWithEmailAndPassword(useremail,userpass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);/*到這邊又隱藏*/
                if(task.isSuccessful()){
                    FirebaseUser user = mAuth.getCurrentUser();
                 //   updateUI(user);
                }else {
                    Toast.makeText(getApplicationContext(), "Authentication failed.",
                            Toast.LENGTH_SHORT).show();/*getApplicationContext這一段也是取得自己本身*/
                 //   updateUI(null);
                }
            }
        });
    }
}
