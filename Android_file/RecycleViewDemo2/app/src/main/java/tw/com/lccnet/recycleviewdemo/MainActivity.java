package tw.com.lccnet.recycleviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import tw.com.lccnet.recycleviewdemo.adapter.RecycleAdapter;
import tw.com.lccnet.recycleviewdemo.beans.ModelRv;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    ArrayList<ModelRv> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.rv);

        arrayList=new ArrayList<>();
        arrayList.add(new ModelRv(R.drawable.icon1,"1","21"));
        arrayList.add(new ModelRv(R.drawable.icon1,"2","22"));
        arrayList.add(new ModelRv(R.drawable.icon1,"3","23"));
        arrayList.add(new ModelRv(R.drawable.icon1,"4","24"));
        arrayList.add(new ModelRv(R.drawable.icon1,"5","25"));
        arrayList.add(new ModelRv(R.drawable.icon1,"6","26"));
        arrayList.add(new ModelRv(R.drawable.icon1,"7","27"));
        arrayList.add(new ModelRv(R.drawable.icon1,"8","28"));






        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLayoutManager=layoutManager;
        recyclerView.setLayoutManager(rvLayoutManager);
        //試這執行
        RecycleAdapter adapter=new RecycleAdapter(this,arrayList);
        recyclerView.setAdapter(adapter);

    }
}
