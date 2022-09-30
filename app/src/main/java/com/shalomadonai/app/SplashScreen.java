package com.shalomadonai.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import static com.shalomadonai.app.R.layout;

public class SplashScreen extends AppCompatActivity implements Runnable {

    Thread thread;
    Handler handler;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_splash_screen);

        handler = new Handler();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        i = 1;

        try {
            while (i < 35) {
                Thread.sleep(15);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        i++;
                    }
                });
            }

        } catch (Exception e) {}
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}