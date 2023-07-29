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

public class karawine extends AppCompatActivity {


    ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karawine);
        ImageSlider imgSlider = findViewById(R.id.image_slider_karawiyuin);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.c__users_editorial_2_downloads_gettyimages_571935259_jpg, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable._rawiyin, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable._____al_qarawiyyin___copie, ScaleTypes.FIT));

        imgSlider.setImageList(slideModels);
        backBtn = findViewById(R.id.back_pressed);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                karawine.super.onBackPressed();
            }
        });
    }

    public void callRetailerScreen(View view) {
        startActivity(new Intent(karawine.this, RetialerStartUpScreen.class));
    }
}