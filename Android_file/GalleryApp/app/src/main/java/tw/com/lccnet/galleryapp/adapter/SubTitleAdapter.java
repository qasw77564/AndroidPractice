package tw.com.lccnet.galleryapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import tw.com.lccnet.galleryapp.R;
import tw.com.lccnet.galleryapp.bean.SubTitleBean;


public class SubTitleAdapter extends RecyclerView.Adapter<SubTitleAdapter.ViewHolder>{
    private Context context;
    private ArrayList<SubTitleBean> subTitleBeanArrayList;

    public SubTitleAdapter(Context context, ArrayList<SubTitleBean> subTitleBeanArrayList) {
        this.context = context;
        this.subTitleBeanArrayList = subTitleBeanArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.activity_sub_title_,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SubTitleBean subTitleBean=subTitleBeanArrayList.get(position);
        ImageView image=holder.sub_images;
        TextView title=holder.sub_title;
        TextView content=holder.sub_content;


        image.setImageResource(subTitleBeanArrayList.get(position).getImaegs());
        title.setText(subTitleBean.getTitle());
        content.setText(subTitleBean.getContent());
    }

    @Override
    public int getItemCount() {
        return subTitleBeanArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView sub_images;
        TextView sub_title,sub_content;
        public ViewHolder(View itemView) {
            super(itemView);
            sub_images=itemView.findViewById(R.id.sub_images);
            sub_title=itemView.findViewById(R.id.sub_title);
            sub_content=itemView.findViewById(R.id.sub_content);
        }
    }
}
