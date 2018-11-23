package tw.com.lccnet.recycleviewdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import tw.com.lccnet.recycleviewdemo.R;
import tw.com.lccnet.recycleviewdemo.beans.ModelRv;

/**
 * Created by Student on 2018/3/26.
 *
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ModelRv> mlist;

    public RecycleAdapter(Context context,ArrayList<ModelRv> list) {
        this.context=context;
        this.mlist=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //取得 rv_item Layout
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.rv_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelRv modelRv=mlist.get(position);
        ImageView image=holder.item_image;
        TextView title=holder.item_title;
        TextView content=holder.item_content;


        image.setImageResource(mlist.get(position).getImaegs());
        title.setText(modelRv.getTitle());
        content.setText(modelRv.getContent());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{
        ImageView item_image;
        TextView item_title,item_content;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_image=itemView.findViewById(R.id.rv_image);
            item_title=itemView.findViewById(R.id.rv_totle);
            item_content=itemView.findViewById(R.id.rv_content);
        }
    }
}
