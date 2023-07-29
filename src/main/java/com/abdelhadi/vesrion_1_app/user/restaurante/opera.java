package com.abdelhadi.vesrion_1_app.user.restaurante;

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

public class opera extends AppCompatActivity {
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opera);
        ImageSlider imgSlider = findViewById(R.id.image_slider_opera);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.fa, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.f2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.f5, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.fc, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.f6, ScaleTypes.FIT));

        imgSlider.setImageList(slideModels);
        backBtn = findViewById(R.id.back_pressed);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opera.super.onBackPressed();
            }
        });
    }

    public void callRetailerScreen(View view) {
        startActivity(new Intent(opera.this, RetialerStartUpScreen.class));
    }
}