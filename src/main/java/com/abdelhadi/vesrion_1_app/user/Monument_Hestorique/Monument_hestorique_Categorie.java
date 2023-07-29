package com.abdelhadi.vesrion_1_app.user.Monument_Hestorique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.abdelhadi.vesrion_1_app.R;
import com.abdelhadi.vesrion_1_app.common.LoginSingUp.RetialerStartUpScreen;
import com.abdelhadi.vesrion_1_app.user.Hotel.Hotel_Categorie;
import com.abdelhadi.vesrion_1_app.user.Hotel.faraj;
import com.abdelhadi.vesrion_1_app.user.Hotel.jnan;
import com.abdelhadi.vesrion_1_app.user.Hotel.larousa;
import com.abdelhadi.vesrion_1_app.user.Hotel.raid;

public class Monument_hestorique_Categorie extends AppCompatActivity {
    RelativeLayout babboujlod,fesbali,njarine,karawine,bouanani,jnansbil,btha,palais;
    ImageView back_pressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monument_hestorique_categorie);
        babboujlod = findViewById(R.id.boujloud);
        back_pressed = findViewById(R.id.back_pressed);
        fesbali = findViewById(R.id.fesbali);
        njarine = findViewById(R.id.njarin);
        karawine= findViewById(R.id.karawine);
        bouanani = findViewById(R.id.boanani);
        jnansbil = findViewById(R.id.jnansbil);
        palais = findViewById(R.id.palais);
        btha = findViewById(R.id.darbtha);
        // Set click listeners
        babboujlod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Monument_hestorique_Categorie.this,boujlod.class);
                startActivities(new Intent[]{intent2});
            }
        });
        fesbali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Monument_hestorique_Categorie.this,fesElbali.class);
                startActivities(new Intent[]{intent2});
            }
        });
        btha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Monument_hestorique_Categorie.this,batha.class);
                startActivities(new Intent[]{intent2});
            }
        });
        karawine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Monument_hestorique_Categorie.this,karawine.class);
                startActivities(new Intent[]{intent2});
            }
        });
        palais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Monument_hestorique_Categorie.this,palais_royal.class);
                startActivities(new Intent[]{intent2});
            }
        });
        njarine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Monument_hestorique_Categorie.this,elNjarine.class);
                startActivities(new Intent[]{intent2});
            }
        });
        bouanani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Monument_hestorique_Categorie.this,bouanani.class);
                startActivities(new Intent[]{intent2});
            }
        });
        jnansbil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Monument_hestorique_Categorie.this,jnansbile.class);
                startActivities(new Intent[]{intent2});
            }
        });
        back_pressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Monument_hestorique_Categorie.super.onBackPressed();
            }
        });
    }





    public void callRetailerScreen(View view) {

        startActivity(new Intent(getApplicationContext(), RetialerStartUpScreen.class));

    }
}