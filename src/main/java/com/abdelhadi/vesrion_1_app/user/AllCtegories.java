package com.abdelhadi.vesrion_1_app.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.abdelhadi.vesrion_1_app.R;
import com.abdelhadi.vesrion_1_app.common.LoginSingUp.RetialerStartUpScreen;
import com.abdelhadi.vesrion_1_app.user.Hospitale.Hospital_Categorie;
import com.abdelhadi.vesrion_1_app.user.Hotel.Hotel_Categorie;
import com.abdelhadi.vesrion_1_app.user.Hotel.larousa;
import com.abdelhadi.vesrion_1_app.user.Hotel.raid;
import com.abdelhadi.vesrion_1_app.user.Monument_Hestorique.Monument_hestorique_Categorie;
import com.abdelhadi.vesrion_1_app.user.Station_transport.Station_transport_Categorie;
import com.abdelhadi.vesrion_1_app.user.restaurante.Restaurant;

public class AllCtegories extends AppCompatActivity {
    RelativeLayout statios_i,Hospital,restaurant,Hotel,shop,MonumentHestorique;
    ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_ctegories);
        statios_i = findViewById(R.id.statios_id);
        Hospital =findViewById(R.id.Hospital_id);
        restaurant =findViewById(R.id.restaurant_id);
        backBtn =findViewById(R.id.back_pressed);
        Hotel= findViewById(R.id.Hotel_id);
        shop = findViewById(R.id.shop_id);
        MonumentHestorique =findViewById(R.id.MonumentHestorique_id);
        // Set click listeners
        statios_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(AllCtegories.this, Station_transport_Categorie.class);
                startActivities(new Intent[]{intent2});
            }
        });
        Hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(AllCtegories.this, Hospital_Categorie.class);
                startActivities(new Intent[]{intent2});
            }
        });
        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(AllCtegories.this, Restaurant.class);
                startActivities(new Intent[]{intent2});
            }
        });
        Hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(AllCtegories.this, Hotel_Categorie.class);
                startActivities(new Intent[]{intent2});

            }
        });
        MonumentHestorique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(AllCtegories.this, Monument_hestorique_Categorie.class);
                startActivities(new Intent[]{intent2});
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllCtegories.super.onBackPressed();
            }
        });
    }
    public void callRetailerScreen(View view) {

        startActivity(new Intent(getApplicationContext(), RetialerStartUpScreen.class));

    }

}