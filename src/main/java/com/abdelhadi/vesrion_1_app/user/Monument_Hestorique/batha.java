package com.abdelhadi.vesrion_1_app.user.Monument_Hestorique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.abdelhadi.vesrion_1_app.R;
import com.abdelhadi.vesrion_1_app.common.LoginSingUp.RetialerStartUpScreen;
import com.abdelhadi.vesrion_1_app.user.Hotel.BlueMaison;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class batha extends AppCompatActivity {
    ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batha);

        ImageSlider imgSlider = findViewById(R.id.image_slider_btha);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.bat7aa2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.bat7aaa, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.dar_batha_museum, ScaleTypes.FIT));

        imgSlider.setImageList(slideModels);
        backBtn = findViewById(R.id.back_pressed);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                batha.super.onBackPressed();
            }
        });
    }

    public void callRetailerScreen(View view) {
        startActivity(new Intent(batha.this, RetialerStartUpScreen.class));
    }
}