package tw.com.lccnet.galleryapp.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;
import java.util.List;

import tw.com.lccnet.galleryapp.ItemActivity;
import tw.com.lccnet.galleryapp.R;
import tw.com.lccnet.galleryapp.bean.Album;
import tw.com.lccnet.galleryapp.config.Config;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    List<Album> list = new ArrayList<>();
    Activity activity;

    RecyclerAdapter() {
    }

    public RecyclerAdapter(List<Album> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.Title.setText(list.get(position).getTitle());
        final String path = Config.url_server + "images/" + list.get(position).getId() + ".jpg";
        //Glide.with(activity).load(path).into(holder.Thuball);
        Glide.with(activity).load(path).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                holder.progressBar.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                holder.progressBar.setVisibility(View.GONE);
                return false;
            }
        }).into(holder.Thuball);

        holder.Thuball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, ItemActivity.class);
                i.putExtra("url", path);
                i.putExtra("title", list.get(position).getTitle());
                activity.startActivity(i);
            }
        });

        holder.menu_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(activity, holder.menu_item);
                popupMenu.inflate(R.menu.option_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_save:
                                Toast.makeText(activity, "Test Save", Toast.LENGTH_LONG).show();
                                break;
                            case R.id.action_delete:
                                Toast.makeText(activity, "Test Delete", Toast.LENGTH_LONG).show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView Thuball;
        TextView Title;
        TextView context;
        ProgressBar progressBar;
        TextView menu_item;

        public MyViewHolder(View itemView) {
            super(itemView);
            Thuball = itemView.findViewById(R.id.thubamil);
            Title = itemView.findViewById(R.id.title);
            progressBar = itemView.findViewById(R.id.progressBar);
            context = itemView.findViewById(R.id.context);
            menu_item = itemView.findViewById(R.id.menu_item);
        }
    }


}
