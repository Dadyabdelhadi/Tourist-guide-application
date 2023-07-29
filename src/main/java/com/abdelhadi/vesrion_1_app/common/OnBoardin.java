package com.abdelhadi.vesrion_1_app.common;

import android.content.Intent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.abdelhadi.vesrion_1_app.ClassHelper.SliderAdapter;
import com.abdelhadi.vesrion_1_app.R;
import com.abdelhadi.vesrion_1_app.user.User_Dashboerd;
import com.abdelhadi.vesrion_1_app.user.your_choise;

public class OnBoardin extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button letsGetStarted,next,skip;
    Animation animation;
    int currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boardin);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Hooks
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        letsGetStarted = findViewById(R.id.get_started_btn);
        skip = findViewById(R.id.skip_btn);
        next = findViewById(R.id.next_btn);

        //Call adapter
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        //Dots
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }


    public void skip(View view) {
        startActivity(new Intent(this, your_choise.class));
        finish();
    }

    public void next(View view) {
        viewPager.setCurrentItem(currentPos + 1);
        startActivity(new Intent(this, your_choise.class));
        finish();
    }


    private void addDots(int position) {

        dots = new TextView[4];
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.yellow));
        }

    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            currentPos = position;

            if (position == 0) {
                letsGetStarted.setVisibility(View.INVISIBLE);
                skip.setVisibility(View.INVISIBLE);

            } else if (position == 1) {
                letsGetStarted.setVisibility(View.INVISIBLE);
                skip.setVisibility(View.INVISIBLE);
            } else if (position == 2) {
                letsGetStarted.setVisibility(View.INVISIBLE);
                animation = AnimationUtils.loadAnimation(OnBoardin.this, R.anim.butt_animation);
                skip.setVisibility(View.INVISIBLE);
            } else {
                animation = AnimationUtils.loadAnimation(OnBoardin.this, R.anim.butt_animation);
                letsGetStarted.setAnimation(animation);
                letsGetStarted.setVisibility(View.VISIBLE);
                skip.setVisibility(View.INVISIBLE);

            }

        }


        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void getstarted(View view) {
        startActivity(new Intent(OnBoardin.this, your_choise.class));
        finish();
    }
}
