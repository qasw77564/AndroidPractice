package tw.com.lccnet.navigationdemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tw.com.lccnet.navigationdemo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment04 extends Fragment {


    public Fragment04() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fragment04, container, false);
        return view;
    }

}
