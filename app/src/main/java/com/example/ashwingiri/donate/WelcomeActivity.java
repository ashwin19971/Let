package com.example.ashwingiri.donate;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    public PreferenceManager preferenceManager;
    LinearLayout Layout_bars;
    ImageView[] bottomBars;
    int[] screens=new int[4];
    Button btnSkip, btnNext;
    ViewPager vp;
    MyViewPagerAdapter myvpAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        vp = (ViewPager) findViewById(R.id.view_pager);
        Layout_bars = (LinearLayout) findViewById(R.id.layoutDots);
        btnSkip = (Button) findViewById(R.id.btnSkip);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnSkip.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        myvpAdapter = new MyViewPagerAdapter();
        vp.setAdapter(myvpAdapter);
        preferenceManager = new PreferenceManager(this);
        vp.addOnPageChangeListener(viewPagerPageChangeListener);
        if (!preferenceManager.FirstLaunch()) {
            launchMain();
            finish();
        }
        screens = new int[]{
                R.layout.welcomeslide1,
                R.layout.welcomeslide2,
                R.layout.welcomeslide3,
                R.layout.welcomeslide4
        };
        ColoredBars(0);
    }

    private void ColoredBars(int thisScreen) {
//        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);
//        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        bottomBars = new ImageView[screens.length];

        Layout_bars.removeAllViews();
        for (int i = 0; i < bottomBars.length; i++) {
            bottomBars[i] = new ImageView(this);

            bottomBars[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_selected_item_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            Layout_bars.addView(bottomBars[i],params);
        }
        if (bottomBars.length > 0){
            bottomBars[thisScreen].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.selected_item_dot));
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//            params.setMargins(8, 0, 8, 0);
//            Layout_bars.addView(bottomBars[thisScreen],params);
        }
    }

    private int getItem(int i) {
        return vp.getCurrentItem() + i;
    }

    private void launchMain() {
        preferenceManager.setFirstTimeLaunch(false);
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            ColoredBars(position);

            if (position == screens.length - 1) {
                btnNext.setText("Let's Started");
                btnSkip.setVisibility(View.GONE);
            } else {
                btnNext.setText("Next>>");
                btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnSkip){
            vp.setCurrentItem(screens.length-1);
        }else{
            int i = getItem(+1);
            if (i < screens.length) {
                vp.setCurrentItem(i);
            }
            if(i==screens.length-1){
                launchMain();
            }
        }
    }

    public class MyViewPagerAdapter extends PagerAdapter{
        private LayoutInflater inflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(screens[position], container, false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return screens.length;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v = (View) object;
            container.removeView(v);
        }

        @Override
        public boolean isViewFromObject(View v, Object object) {
            return v == object;
        }
    }
}

//    public class MyViewPagerAdapter extends PagerAdapter {
//        private LayoutInflater inflater;
//
//        public MyViewPagerAdapter() {
//        }
//
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View view = inflater.inflate(screens[position], container, false);
//            container.addView(view);
//            return view;
//        }
//
//        @Override
//        public int getCount() {
//            return screens.length;
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            View v = (View) object;
//            container.removeView(v);
//        }
//
//        @Override
//        public boolean isViewFromObject(View v, Object object) {
//            return v == object;
//        }
//    }





