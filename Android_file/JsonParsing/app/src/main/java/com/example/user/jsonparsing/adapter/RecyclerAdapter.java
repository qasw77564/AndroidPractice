package com.example.user.jsonparsing.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.jsonparsing.R;
import com.example.user.jsonparsing.bean.Contact;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private List<Contact> list=new ArrayList<>();

    RecyclerAdapter(List<Contact> list){
        this.list=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);




        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Id.setText(Integer.toString(Integer.parseInt(list.get(position).getId())));
        holder.Name.setText(list.get(position).getName());
        holder.Email.setText(list.get(position).getEmail());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Id,Name,Email;


        public MyViewHolder(View itemView) {
            super(itemView);
            Id=itemView.findViewById(R.id.mId);
            Name=itemView.findViewById(R.id.mName);
            Email=itemView.findViewById(R.id.mEmail);

        }

    }


}
