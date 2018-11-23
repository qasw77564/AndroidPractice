package tw.com.lccnet.app.jsondemo.model;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tw.com.lccnet.app.jsondemo.Contacts;
import tw.com.lccnet.app.jsondemo.R;

/**
 * Created by Student on 2017/9/10.
 */

public class RecyleAdapter extends RecyclerView.Adapter<RecyleAdapter.MyViewHolder>{

    private List<Contacts> list=new ArrayList<>();
    public RecyleAdapter(List<Contacts> list){

        this.list=list;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyleAdapter.MyViewHolder holder, int position) {
        holder.id.setText(list.get(position).getId());
        holder.name.setText(list.get(position).getName());
        holder.email.setText(list.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id,name,email;
        public MyViewHolder(View itemView) {
            super(itemView);
            id= (TextView) itemView.findViewById(R.id.id);
            name= (TextView) itemView.findViewById(R.id.name);
            email= (TextView) itemView.findViewById(R.id.email);
        }
    }
}
