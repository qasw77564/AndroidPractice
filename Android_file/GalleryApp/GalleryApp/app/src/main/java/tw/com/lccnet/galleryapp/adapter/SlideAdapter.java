package tw.com.lccnet.galleryapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import tw.com.lccnet.galleryapp.R;
import tw.com.lccnet.galleryapp.config.Config;

public class SlideAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private String slide_path = Config.url_server + "images/";
    private String[] image_slde = {slide_path + "guide1.jpeg", slide_path + "guide2.jpeg", slide_path + "guid3.jpg"};

    public SlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return image_slde.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.pager_item, container, false);
        ImageView slide_View = view.findViewById(R.id.page_image);
        //slide_View.setImageResource(image_slde[position]);
        Glide.with(context).load(image_slde[position]).into(slide_View);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
