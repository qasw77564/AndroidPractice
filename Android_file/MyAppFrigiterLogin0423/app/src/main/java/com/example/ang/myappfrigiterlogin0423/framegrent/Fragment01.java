package com.example.ang.myappfrigiterlogin0423.framegrent;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ang.myappfrigiterlogin0423.R;
import com.example.ang.myappfrigiterlogin0423.model.BackgroundTask;


public class Fragment01 extends Fragment {
    private View view;
    private Context ctx;
    Button btn_login;
    EditText etlusername,etluserpass;
    String Lname,Lpass;
   //private Context ctx;


    public Fragment01() {
        // Required empty public constructor
    }

//    public Fragment01(Context ctx) {
//        // Required empty public constructor
//        this.ctx=ctx;
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ctx=getActivity();
        view=inflater.inflate(R.layout.fragment_01, container, false);
        //init();
        etlusername=(EditText)view.findViewById(R.id.editTextLusername);
        etluserpass=(EditText)view.findViewById(R.id.editTextLuserpass);
        btn_login=(Button)view.findViewById(R.id.button);

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lname=etlusername.getText().toString().trim();
                Lpass=etluserpass.getText().toString().trim();
               // Toast.makeText(getActivity(),Lname,Toast.LENGTH_SHORT).show();
               // Log.d("Tag",Lname);
                String method="login";
                BackgroundTask backgroundTask=new BackgroundTask(getActivity());
                backgroundTask.execute(method,Lname,Lpass);
            }
        });

    }

    //    public void click_login(View v){
//        Lname=etlusername.getText().toString().trim();
//        Lpass=etluserpass.getText().toString().trim();
//        String method="login";
//        BackgroundTask backgroundTask=new BackgroundTask(getContext());
//        backgroundTask.execute(method,Lname,Lpass);
//    }




}
