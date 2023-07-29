package com.abdelhadi.vesrion_1_app.user.Hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.abdelhadi.vesrion_1_app.R;
import com.abdelhadi.vesrion_1_app.common.LoginSingUp.RetialerStartUpScreen;

public class Hotel_Categorie extends AppCompatActivity {

    ImageView raidfes,maisonbleu,laarosa,jnan,faraj,backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_categorie);
        raidfes = findViewById(R.id.raidfes);
        maisonbleu =findViewById(R.id.maisonbleu);
        laarosa =findViewById(R.id.laarosa);
        jnan= findViewById(R.id.jnan);
        faraj = findViewById(R.id.faraj);
        backBtn =findViewById(R.id.back_pressed);
        // Set click listeners
        raidfes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Hotel_Categorie.this,raid.class);
                startActivities(new Intent[]{intent2});
            }
        });
        maisonbleu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Hotel_Categorie.this,BlueMaison.class);
                startActivities(new Intent[]{intent2});
            }
        });
        laarosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Hotel_Categorie.this,larousa.class);
                startActivities(new Intent[]{intent2});
            }
        });
        jnan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Hotel_Categorie.this,jnan.class);
                startActivities(new Intent[]{intent2});

            }
        });
        faraj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Hotel_Categorie.this,faraj.class);
                startActivities(new Intent[]{intent2});
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hotel_Categorie.super.onBackPressed();
            }
        });
    }





    public void callRetailerScreen(View view) {

        startActivity(new Intent(getApplicationContext(),RetialerStartUpScreen.class));

    }



}
