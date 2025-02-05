package com.hzlrknbdk.asosyal.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.hzlrknbdk.asosyal.R;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lottieAnimationView = findViewById(R.id.splash_animation);
        SplashAnimation();
        pushFragment();

    }

    private void pushFragment() {

        int SPLASH_TIME = 4000;
        new Handler().postDelayed(() -> {
            lottieAnimationView.setVisibility(View.GONE);
            Intent intent = new Intent(this, IntroViewPage.class);
            startActivity(intent);
        }, SPLASH_TIME);
    }

    public void SplashAnimation() {
        LottieAnimationView animationView = findViewById(R.id.splash_animation);
        animationView.setAnimation("loading.json");
        animationView.playAnimation();

    }


}