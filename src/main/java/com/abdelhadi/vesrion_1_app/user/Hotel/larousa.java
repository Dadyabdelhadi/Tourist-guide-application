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

public class larousa extends AppCompatActivity {
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_larousa);
        ImageSlider imgSlider = findViewById(R.id.image_slider);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.larousa3__1_, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.arousa1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.arousapic, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.arousa1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.larousa3__1_, ScaleTypes.FIT));



        imgSlider.setImageList(slideModels);
        backBtn = findViewById(R.id.back_pressed);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                larousa.super.onBackPressed();
            }
        });
    }

    public void callRetailerScreen(View view) {
        startActivity(new Intent(larousa.this, RetialerStartUpScreen.class));
    }

}