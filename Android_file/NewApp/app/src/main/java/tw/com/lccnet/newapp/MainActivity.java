package tw.com.lccnet.newapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import tw.com.lccnet.newapp.fragment.ContextFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //主頁面
        setContentView(R.layout.activity_main);
       // 設定menu
        initFragment();
    }

    private void initFragment() {

        //1:得到Fragment
        FragmentManager fm=getSupportFragmentManager();
        //2.開啟事務
        FragmentTransaction ft=fm.beginTransaction();
        //3:替換
        ft.replace(R.id.main_fragment,new ContextFragment(),"main_context_tag");
        //4:提交
        ft.commit();



    }
}
