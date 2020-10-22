package com.cricket.cricket.api.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.cricket.cricket.api.R;


public class MainActivity extends AppCompatActivity {
    ImageView cricketFront;
    CountDownTimer countTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_splash_screen);


        cricketFront = findViewById(R.id.cricketSplash);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_leftoright);
        cricketFront.startAnimation(animation);

        countTimer = new CountDownTimer(2290,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, DashboardController.class);
                startActivity(intent);
                finish(); //cut activity
            }
        }.start();


    }
}