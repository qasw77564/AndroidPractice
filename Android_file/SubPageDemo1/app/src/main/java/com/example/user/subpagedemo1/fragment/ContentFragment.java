package com.example.user.subpagedemo1.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;

import com.example.user.subpagedemo1.R;
import com.example.user.subpagedemo1.basefragment.BaseFragment;

public class ContentFragment extends BaseFragment {
    private ViewPager viewPager;
    private RadioGroup radioGroup;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View initView() {
        View view=View.inflate(context, R.layout.content_layout,null);
        viewPager=view.findViewById(R.id.viewpage);
        radioGroup=view.findViewById(R.id.radgroup);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        radioGroup.check(R.id.rb_home);
    }
}
