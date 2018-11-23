package com.example.user.subpagedemo.fragment;


import android.view.View;
import com.example.user.subpagedemo.R;
import com.example.user.subpagedemo.baseFragment.BaseFragment;

public class LeftMenuFragment extends BaseFragment {
    @Override
    public View initView() {
        View view=View.inflate(context, R.layout.left_layout,null);
        return view;
    }
}
