package com.hzlrknbdk.asosyal.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.hzlrknbdk.asosyal.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LottieAnimationView animationView = findViewById(R.id.splash_animation);
        animationView.setAnimation("preloader2.json");
        animationView.playAnimation();

    }


}
