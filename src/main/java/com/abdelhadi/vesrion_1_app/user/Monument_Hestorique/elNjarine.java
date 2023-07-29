package com.abdelhadi.vesrion_1_app.user.Monument_Hestorique;

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

public class elNjarine extends AppCompatActivity {
    ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_njarine);
        ImageSlider imgSlider = findViewById(R.id.image_slider_elnjarin);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.moroccan_joinery___copie, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.najjarinefountain_fez00002, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.nejjarine_museum_of_wooden_arts___crafts___copie, ScaleTypes.FIT));

        imgSlider.setImageList(slideModels);
        backBtn = findViewById(R.id.back_pressed);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elNjarine.super.onBackPressed();
            }
        });
    }

    public void callRetailerScreen(View view) {
        startActivity(new Intent(elNjarine.this, RetialerStartUpScreen.class));
    }
}