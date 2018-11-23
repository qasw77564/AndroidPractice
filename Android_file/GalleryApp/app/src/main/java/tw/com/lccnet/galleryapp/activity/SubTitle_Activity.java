package tw.com.lccnet.galleryapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import tw.com.lccnet.galleryapp.R;
import tw.com.lccnet.galleryapp.adapter.SubTitleAdapter;
import tw.com.lccnet.galleryapp.bean.SubTitleBean;

public class SubTitle_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<SubTitleBean> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_title_);
        recyclerView=findViewById(R.id.recycleview);
        arrayList=new ArrayList<>();

        arrayList.add(new SubTitleBean(R.drawable.gui01,"1","21"));
        arrayList.add(new SubTitleBean(R.drawable.gui02,"2","22"));
        arrayList.add(new SubTitleBean(R.drawable.gui03,"3","23"));






        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLayoutManager=layoutManager;
        recyclerView.setLayoutManager(rvLayoutManager);
        //試這執行
        SubTitleAdapter adapter=new SubTitleAdapter(this,arrayList);
        recyclerView.setAdapter(adapter);


    }


}
