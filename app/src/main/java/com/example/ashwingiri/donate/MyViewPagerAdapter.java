package com.example.ashwingiri.donate;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Admin on 3/21/2018.
 */

public class MyViewPagerAdapter extends PagerAdapter {

    int[] images = {R.drawable.hye, R.drawable.imagesnine, R.drawable.imagesfive, R.drawable.imageq, R.drawable.images};
    Context context;
    LayoutInflater layoutInflater;

    public MyViewPagerAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_pages, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imgv_pages);
        imageView.setImageResource(this.images[position]);

        ViewPager v = (ViewPager) container;
        v.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}
