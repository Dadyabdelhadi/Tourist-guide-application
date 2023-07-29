package com.abdelhadi.vesrion_1_app.user.Hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.abdelhadi.vesrion_1_app.R;
import com.abdelhadi.vesrion_1_app.common.LoginSingUp.RetialerStartUpScreen;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class raid extends AppCompatActivity {
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raid);
        ImageSlider imgSlider = findViewById(R.id.image_slider);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.raid, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.raidfes, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.lobby, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.raidchateaux, ScaleTypes.FIT));

        imgSlider.setImageList(slideModels);
        backBtn = findViewById(R.id.back_pressed);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                raid.super.onBackPressed();
            }
        });
    }

    public void callRetailerScreen(View view) {
        startActivity(new Intent(raid.this, RetialerStartUpScreen.class));
    }

}