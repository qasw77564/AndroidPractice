package tw.com.lccnet.app.tablayoutdemo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import tw.com.lccnet.app.tablayoutdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {

    Button btn1;
    public Fragment1() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("首頁");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fragment1, container, false);
        btn1= (Button) view.findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"hahaha",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

}
