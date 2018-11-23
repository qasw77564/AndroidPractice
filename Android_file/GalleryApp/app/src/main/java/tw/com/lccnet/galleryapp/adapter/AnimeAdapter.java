package tw.com.lccnet.galleryapp.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;
import tw.com.lccnet.galleryapp.R;
import tw.com.lccnet.galleryapp.activity.AnimeClickActivity;
import tw.com.lccnet.galleryapp.bean.Anime;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.MyViewHolder>{
    private Activity activity;
    private List<Anime> mAnimes;
    RequestOptions option;

    public AnimeAdapter() {
    }

    public AnimeAdapter(Activity activity, List<Anime> mAnimes) {
        this.activity = activity;
        this.mAnimes = mAnimes;
        //Request option for Glide
        option=new RequestOptions().centerCrop().placeholder(R.drawable.loding_shape).error(R.drawable.loding_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view_a;
        LayoutInflater inflater_a=LayoutInflater.from(activity);
        view_a=inflater_a.inflate(R.layout.anime_row_item,parent,false);
        final MyViewHolder myViewHolder=new MyViewHolder(view_a);
        myViewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(activity, AnimeClickActivity.class);
                i.putExtra("anime_name",mAnimes.get(myViewHolder.getAdapterPosition()).getName());
                i.putExtra("anime_description",mAnimes.get(myViewHolder.getAdapterPosition()).getDescription());
                i.putExtra("anime_studio",mAnimes.get(myViewHolder.getAdapterPosition()).getStudio());
                i.putExtra("anime_category",mAnimes.get(myViewHolder.getAdapterPosition()).getCategorie());
                i.putExtra("anime_nb_episode",mAnimes.get(myViewHolder.getAdapterPosition()).getNb_episode());
                i.putExtra("anime_img",mAnimes.get(myViewHolder.getAdapterPosition()).getImages_url());
                i.putExtra("anime_rating",mAnimes.get(myViewHolder.getAdapterPosition()).getRating());
                activity.startActivity(i);
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(mAnimes.get(position).getName());
        holder.tv_rating.setText(mAnimes.get(position).getRating());
        holder.tv_studio.setText(mAnimes.get(position).getStudio());
        holder.tv_category.setText(mAnimes.get(position).getCategorie());
        //Load Image from the internet and set it into Imageview using Glide
        Glide.with(activity).load(mAnimes.get(position).getImages_url()).apply(option).into(holder.image_thumbnail);
    }

    @Override
    public int getItemCount() {
        return mAnimes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name,tv_rating,tv_studio,tv_category;
        ImageView image_thumbnail;
        LinearLayout view_container;
        public MyViewHolder(View itemView) {
            super(itemView);
            view_container=itemView.findViewById(R.id.container_a);
            tv_name=itemView.findViewById(R.id.anime_name);
            tv_rating=itemView.findViewById(R.id.rating);
            tv_studio=itemView.findViewById(R.id.studio);
            tv_category=itemView.findViewById(R.id.categorie);
            image_thumbnail=itemView.findViewById(R.id.thumbnail);
        }
    }
}
