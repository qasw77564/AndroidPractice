package com.example.user.databaseconnction.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.databaseconnction.R;
import com.example.user.databaseconnction.model.BackgroundTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment01 extends Fragment {
    private View view;
    private Context ctx;
    Button m_login,m_register;
    EditText m_name,m_pass;
    String st_name,st_pass;
    public Fragment01() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_fragment01, container, false);
        m_login=(Button) view.findViewById(R.id.m_login);
        m_register=(Button) view.findViewById(R.id.m_register);

        m_name=(EditText) view.findViewById(R.id.m_name);
        m_pass=(EditText) view.findViewById(R.id.m_pass);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
     /*   m_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st_name=m_name.getText().toString().trim();
                st_pass=m_pass.getText().toString().trim();
                // Toast.makeText(getActivity(),Lname,Toast.LENGTH_SHORT).show();
                // Log.d("Tag",Lname);
                String method="login";
                BackgroundTask backgroundTask=new BackgroundTask(getActivity());
                backgroundTask.execute(method,st_name,st_pass);
            }
        });
        */
        super.onActivityCreated(savedInstanceState);
    }
}
