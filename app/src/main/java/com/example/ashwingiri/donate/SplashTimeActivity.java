package com.example.ashwingiri.donate;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashTimeActivity extends AppCompatActivity {

    public static int SPLASH_TIME_OUT=1200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_time);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),WelcomeActivity.class));
                finish();
            }
        },SPLASH_TIME_OUT);
    }

}
