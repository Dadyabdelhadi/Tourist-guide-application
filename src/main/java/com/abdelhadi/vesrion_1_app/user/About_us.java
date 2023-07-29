package com.abdelhadi.vesrion_1_app.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.abdelhadi.vesrion_1_app.R;
import androidx.appcompat.app.AppCompatActivity;

public class About_us extends AppCompatActivity {
Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        but=findViewById(R.id.button_started_about);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(About_us.this, User_Dashboerd.class));
            }
        });
    }
}