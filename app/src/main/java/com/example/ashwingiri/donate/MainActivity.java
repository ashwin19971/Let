package com.example.ashwingiri.donate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View v) {
        Intent n = new Intent(this, UserRegistration.class);
        startActivity(n);

    }

    public void click2(View v) {
        Intent n = new Intent(this, NGO_registrarion.class);

        startActivity(n);

    }

    public void click3(View v) {
        Intent n = new Intent(this, Login.class);

        startActivity(n);

    }
    public void click4(View v) {
        Intent n = new Intent(this, NavDrawerActivityMain.class);

        startActivity(n);

    }
}
