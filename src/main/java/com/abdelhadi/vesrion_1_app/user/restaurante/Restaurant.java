package com.abdelhadi.vesrion_1_app.user.restaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.abdelhadi.vesrion_1_app.R;
import com.abdelhadi.vesrion_1_app.common.LoginSingUp.RetialerStartUpScreen;

public class Restaurant extends AppCompatActivity {
    ImageView thelost,operra,letarbouche,lebazar,momtauche,ghlia,backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categori_restaurants);
        backBtn =findViewById(R.id.back_pressed);
        // Set click listeners
        thelost=findViewById(R.id.lost);
        operra=findViewById(R.id.operaa);
        letarbouche=findViewById(R.id.tarbouche);
        lebazar=findViewById(R.id.bazare);
        momtauche=findViewById(R.id.momtauche);
        ghlia=findViewById(R.id.ralia);

        thelost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Restaurant.this,thelost.class);
                startActivities(new Intent[]{intent3});
            }
        });
        operra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Restaurant.this,opera.class);
                startActivities(new Intent[]{intent3});
            }
        });
        lebazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Restaurant.this,bazar.class);
                startActivities(new Intent[]{intent3});
            }
        });
        letarbouche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Restaurant.this,tarbouch.class);
                startActivities(new Intent[]{intent3});
            }
        });
        ghlia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Restaurant.this,ghalia.class);
                startActivities(new Intent[]{intent3});
            }
        });
        momtauche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Restaurant.this,momtauch.class);
                startActivities(new Intent[]{intent3});
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Restaurant.super.onBackPressed();
            }
        });
    }





    public void callRetailerScreen(View view) {

        startActivity(new Intent(getApplicationContext(), RetialerStartUpScreen.class));

    }




}