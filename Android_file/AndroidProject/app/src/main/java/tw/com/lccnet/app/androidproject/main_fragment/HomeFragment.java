package tw.com.lccnet.app.androidproject.main_fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tw.com.lccnet.app.androidproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
private ViewPager viewpager;

    public HomeFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("首頁");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        viewpager= (ViewPager) view.findViewById(R.id.viewpager);
        return view;
    }

}
