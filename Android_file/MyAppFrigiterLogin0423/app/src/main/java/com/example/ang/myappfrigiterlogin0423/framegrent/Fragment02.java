package com.example.ang.myappfrigiterlogin0423.framegrent;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ang.myappfrigiterlogin0423.R;
import com.example.ang.myappfrigiterlogin0423.model.BackgroundTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment02 extends Fragment {
    View view;
Button btn_register;
    EditText etrname,etrusername,etruserpass;
    String rname,rusername,ruserpass;
Context cctx;
    public Fragment02() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cctx=getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_02, container, false);
        etrname=(EditText)view.findViewById(R.id.editTextRname);
        etrusername=(EditText)view.findViewById(R.id.editTextRusername);
        etruserpass=(EditText)view.findViewById(R.id.editTextRuserpass);
        btn_register=(Button)view.findViewById(R.id.buttonR);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rname=etrname.getText().toString().trim();
                rusername=etrusername.getText().toString().trim();
                ruserpass=etruserpass.getText().toString().trim();
                String method="register";
                BackgroundTask backgroundTask=new BackgroundTask(cctx);
                backgroundTask.execute(method,rname,rusername,ruserpass);
            }
        });
    }
}
