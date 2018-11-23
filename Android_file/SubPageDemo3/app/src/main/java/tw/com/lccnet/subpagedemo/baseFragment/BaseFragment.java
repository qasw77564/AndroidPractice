package tw.com.lccnet.subpagedemo.baseFragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class BaseFragment extends Fragment {

    //BaseFragment父類別往下衍生

    public Context context;
    //或 public Activity context;




    //自己加入方法onCreate
    /*
          當Fragment被創建時調用這個方法
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getActivity();
    }


    //自己加入方法onCreateView
    /*
          當Fragment 的元件被創建時要調用這個方法
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return initView();
        //要在子類別作
    }

    //抽象方法 子類別實作
    //建立自己的抽象類別，繼承後的子類別需要實作抽象方法
    public abstract View initView() ;

    //自己加入方法onActivityCreated
    /*
          當Activity建立時會調用這個方法
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
    }

    /*
        如果頁面沒有數據(資料)進行請求
        如果頁面有數據，就將數據給init的方法上
     */
    public void initData() {

    }
}
