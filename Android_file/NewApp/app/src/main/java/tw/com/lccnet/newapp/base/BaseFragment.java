package tw.com.lccnet.newapp.base;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/*
     自訂Fragment
  */
public abstract class BaseFragment extends Fragment {

    public Activity context;  //activity== context   Mainactivity
    /**
     * 當我Fragment創建時調用這個方法
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getActivity();
    }

    /**
     *   當頁面被建立時需要調用這個方法
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return  回傳頁面內容
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

        /**
         * 當Activity創建後被調用
         * @param savedInstanceState
         */
        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            initData();
        }
        /*
            如果子頁面需要數據可以複寫此方法
         */
        public  void initData(){

        }


        public abstract View initView();






    }
