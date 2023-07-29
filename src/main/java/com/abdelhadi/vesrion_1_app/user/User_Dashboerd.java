package com.abdelhadi.vesrion_1_app.user;


import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abdelhadi.vesrion_1_app.R;
import com.abdelhadi.vesrion_1_app.common.LoginSingUp.RetialerStartUpScreen;
import com.abdelhadi.vesrion_1_app.user.Hospitale.Hospital_Categorie;
import com.abdelhadi.vesrion_1_app.user.Hotel.BlueMaison;
import com.abdelhadi.vesrion_1_app.user.Hotel.Hotel_Categorie;
import com.abdelhadi.vesrion_1_app.user.Hotel.faraj;
import com.abdelhadi.vesrion_1_app.user.Monument_Hestorique.Monument_hestorique_Categorie;
import com.abdelhadi.vesrion_1_app.user.Monument_Hestorique.batha;
import com.abdelhadi.vesrion_1_app.user.Monument_Hestorique.bouanani;
import com.abdelhadi.vesrion_1_app.user.Station_transport.Station_transport_Categorie;
import com.abdelhadi.vesrion_1_app.user.restaurante.Restaurant;
import com.abdelhadi.vesrion_1_app.user.restaurante.bazar;
import com.abdelhadi.vesrion_1_app.user.restaurante.ghalia;
import com.google.android.material.navigation.NavigationView;
import com.abdelhadi.vesrion_1_app.ClassHelper.HomeAdapter.FeaturedAdapter;
import com.abdelhadi.vesrion_1_app.ClassHelper.HomeAdapter.FeaturedHelperClass;
import com.abdelhadi.vesrion_1_app.ClassHelper.HomeAdapter.MostViewedAdpater;
import com.abdelhadi.vesrion_1_app.ClassHelper.HomeAdapter.MostViewedHelperClass;


import java.util.ArrayList;


public class User_Dashboerd extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    RecyclerView featuredRecycler, mostViewedRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter;
    CardView art1,art2,art3,most_1,most_2,most_3;

    private GradientDrawable gradient1, gradient2, gradient3, gradient4;
    static final float END_SCALE = 0.7f;
    Button button_profile_ic;
    //Drawer Menu

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    LinearLayout statios_ii,Hospitali,restauranti,Hoteli,shopi,MonumentHestoriquei,contentView;

    RelativeLayout statios_i,Hospital,restaurant,Hotel,shop,MonumentHestorique;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboerd);
        //Hooks
        menuIcon = findViewById(R.id.meni_icon);
        contentView = findViewById(R.id.content);
        most_1 =findViewById(R.id.articl1_most);
        most_2 =findViewById(R.id.articl2_most);
        most_3 =findViewById(R.id.articl3_most);
        art1 =findViewById(R.id.articl1);
        art2 =findViewById(R.id.articl2);
        art3 =findViewById(R.id.articl3);

        /*featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);*/
        //Functions will be executed automatically when this activity will be created
        /*featuredRecycler();*/
/*        mostViewedRecycler();*/
        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layou);
        navigationView = findViewById(R.id.navigation_view);
        naviagtionDrawer();
        // navigation drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        statios_i = findViewById(R.id.statios_idd);
        Hospital =findViewById(R.id.Hospital_idD);
        restaurant =findViewById(R.id.restaurant_idd);
        Hotel= findViewById(R.id.Hotel_idd);
        shop = findViewById(R.id.shop_idd);
        MonumentHestorique =findViewById(R.id.MonumentHestorique_idd);
        // Set click listeners
        statios_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(User_Dashboerd.this, Station_transport_Categorie.class);
                startActivities(new Intent[]{intent2});
            }
        });
        Hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(User_Dashboerd.this, Hospital_Categorie.class);
                startActivities(new Intent[]{intent2});
            }
        });
        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(User_Dashboerd.this, Restaurant.class);
                startActivities(new Intent[]{intent2});
            }
        });
        Hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(User_Dashboerd.this, Hotel_Categorie.class);
                startActivities(new Intent[]{intent2});

            }
        });
        MonumentHestorique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(User_Dashboerd.this, Monument_hestorique_Categorie.class);
                startActivities(new Intent[]{intent2});
            }
        });
/////////////////////
        statios_ii = findViewById(R.id.cat_tran);
        Hospitali =findViewById(R.id.cat_hospital);
        restauranti =findViewById(R.id.cat_resto);
        Hoteli= findViewById(R.id.cat_Hotel);
        shopi = findViewById(R.id.cat_shop);
        MonumentHestoriquei =findViewById(R.id.cat_monumn);
        // Set click listeners
        statios_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(User_Dashboerd.this, Station_transport_Categorie.class);
                startActivities(new Intent[]{intent2});
            }
        });
        shopi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(User_Dashboerd.this, Station_transport_Categorie.class);
                startActivities(new Intent[]{intent2});
            }
        });
        Hospitali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(User_Dashboerd.this, Hospital_Categorie.class);
                startActivities(new Intent[]{intent2});
            }
        });
        restauranti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(User_Dashboerd.this, Restaurant.class);
                startActivities(new Intent[]{intent2});
            }
        });
        Hoteli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(User_Dashboerd.this, Hotel_Categorie.class);
                startActivities(new Intent[]{intent2});

            }
        });
        MonumentHestoriquei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(User_Dashboerd.this, Monument_hestorique_Categorie.class);
                startActivities(new Intent[]{intent2});
            }
        });
        art1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(User_Dashboerd.this, batha.class);
                startActivities(new Intent[]{intent2});
            }
        });

        art2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(User_Dashboerd.this, BlueMaison.class);
                startActivities(new Intent[]{intent2});
            }
        });
        art3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(User_Dashboerd.this, bazar.class);
                startActivities(new Intent[]{intent2});
            }
        });
        most_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(User_Dashboerd.this, bouanani.class);
                startActivities(new Intent[]{intent2});
            }
        });
        most_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(User_Dashboerd.this, faraj.class);
                startActivities(new Intent[]{intent2});
            }
        });
        most_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(User_Dashboerd.this, ghalia.class);
                startActivities(new Intent[]{intent2});
            }
        });
    }


    public void callRetailerScreen(View view) {
        startActivity(new Intent(User_Dashboerd.this,RetialerStartUpScreen.class));
    }

    //Navigation Drawer Functions
    private void naviagtionDrawer() {

        //Naviagtion Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);


        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {

        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
        //drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });

    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }




 /*   private void mostViewedRecycler() {
        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(getDrawable(R.drawable.p_2), "Education","dfssssss"));
        mostViewedLocations.add(new MostViewedHelperClass(getDrawable(R.drawable.p_4),"cccccccccc","ccccccccc"));
        mostViewedLocations.add(new MostViewedHelperClass(getDrawable(R.drawable.p_3),"dddddddddd","ddddddddd"));
        mostViewedLocations.add(new MostViewedHelperClass(getDrawable(R.drawable.p_1), "qqqqqqqqqq","qqqqqqqqqqqqqq"));
        adapter = new MostViewedAdpater(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);
    }*/
   /* private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(getDrawable(R.drawable.p_2), "Mcdonald's", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));
        featuredLocations.add(new FeaturedHelperClass(getDrawable(R.drawable.p_2), "Edenrobe", " asudhlasn saudnas jasdjasl hisajdl asjdlnas"));
        featuredLocations.add(new FeaturedHelperClass(getDrawable(R.drawable.p_2), "Walmart", "  saudnas jasdjasl hisajdl asjdlnas"));
        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);

    }*/

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId()){
            case  R.id.nav_all_categories:
                startActivity(new Intent(getApplicationContext(),AllCtegories.class));
                break;
            case  R.id.nav_home:
                startActivity(new Intent(getApplicationContext(),User_Dashboerd.class));
                break;
            case  R.id.nav_rate_us:
                   review();
                break;
            case  R.id.nav_share:
                otherApps();
                break;
            case  R.id.nav_restaurants:
                startActivity(new Intent(getApplicationContext(), Restaurant.class));
                break;
            case  R.id.nav_station:
                startActivity(new Intent(getApplicationContext(), Station_transport_Categorie.class));
                break;
            case  R.id.nav_Hospitale:
                startActivity(new Intent(getApplicationContext(), Hospital_Categorie.class));
                break;
            case  R.id.nav_hotel:
                startActivity(new Intent(getApplicationContext(), Hotel_Categorie.class));
                break;
            case  R.id.nav_historiques:
                startActivity(new Intent(getApplicationContext(), Monument_hestorique_Categorie.class));
                break;
            case R.id.nav_otherapps:
                share();
        }
        return true;
    }

     private void review(){
         final String appPackageName = "com.abdelhadi.vesrion_1_app";

         try {
             startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" +appPackageName)));
         } catch (android.content.ActivityNotFoundException anfe) {
             startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
         }
     }


    private void share(){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=CDT+Puzzle+Studio")));

    }


        private void otherApps() {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Here is the share content body";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}