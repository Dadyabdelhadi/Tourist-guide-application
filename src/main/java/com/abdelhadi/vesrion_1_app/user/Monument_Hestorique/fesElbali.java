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

public class fesElbali extends AppCompatActivity {

    ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fes_elbali);
        ImageSlider imgSlider = findViewById(R.id.image_slider_feselbali);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.t_l_chargement__7____copie, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.aaa, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.aaaaa, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.aaaaaa, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.aaaaaaa, ScaleTypes.FIT));

        imgSlider.setImageList(slideModels);
        backBtn = findViewById(R.id.back_pressed);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fesElbali.super.onBackPressed();
            }
        });
    }

    public void callRetailerScreen(View view) {
        startActivity(new Intent(fesElbali.this, RetialerStartUpScreen.class));
    }
}