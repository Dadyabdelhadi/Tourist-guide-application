package com.abdelhadi.vesrion_1_app.common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.abdelhadi.vesrion_1_app.R;
import com.abdelhadi.vesrion_1_app.user.User_Dashboerd;

public class Splash_screen extends AppCompatActivity {
    TextView title__splash;
    ImageView backgroun_image;
    Animation side_anim, button_anim;
    public static int timer = 5000;
    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        backgroun_image = findViewById(R.id.background_image);
        title__splash = findViewById(R.id.titlsplashh);
        side_anim = AnimationUtils.loadAnimation(this, R.anim.side_animation);
        button_anim = AnimationUtils.loadAnimation(this, R.anim.butt_animation);
        backgroun_image.setAnimation(side_anim);
        backgroun_image.setAnimation(button_anim);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);

                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);

                if (isFirstTime) {
                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();
                } else {

                    Intent mainintent = new Intent(Splash_screen.this, OnBoardin.class);
                    startActivity(mainintent);
                    finish();
                }
            }
        },timer);
    }
}