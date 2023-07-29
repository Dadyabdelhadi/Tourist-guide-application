package com.abdelhadi.vesrion_1_app.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.abdelhadi.vesrion_1_app.R;

public class your_choise extends AppCompatActivity {
    Button but_about,but_getstarted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_choise);

        but_about=findViewById(R.id.ID_about_us);
        but_getstarted=findViewById(R.id.ID_get_started);
        but_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(your_choise.this,About_us.class));
            }
        });

        but_getstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setComponent(new ComponentName("com.abdelhadi.tourismeguidefezcity.user.your_choise",
                        "com.abdelhadi.tourismeguidefezcity.Data.Login"));
                startActivity(intent);*/
                startActivity(new Intent(your_choise.this,User_Dashboerd.class));
            }
        });

    }
}
