package com.example.user.subpagedemo.baseFragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
  //  public Context context;
      public Activity context;
    /*
       當Fragment被創建時需要調用這個方法
    */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getActivity();
    }

    /*
        當Fragment的元件被創建時要調用這個方法
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }
    //建立自己的抽象類別,繼承後的子類別需實做抽象方法
    public abstract View initView();

    /*
        當我們的Activity被建立時這個方法會被調用
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }
    /*
        如果頁面沒有數據或資料,進行請求
        如果頁面有數據或資料,就將數據給init的方法上
     */
    public void initData(){

    };
}
