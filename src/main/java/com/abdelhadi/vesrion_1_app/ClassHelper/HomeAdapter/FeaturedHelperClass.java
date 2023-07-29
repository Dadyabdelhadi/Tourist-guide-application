package com.abdelhadi.vesrion_1_app.ClassHelper.HomeAdapter;

import android.graphics.drawable.Drawable;

public class FeaturedHelperClass {
    Drawable relativeLayout ;
    String titl,description;

    public FeaturedHelperClass(Drawable relativeLayout, String titl, String description) {
        this.relativeLayout = relativeLayout;
        this.titl = titl;
        this.description = description;
    }

    public Drawable getRelativeLayout() {
        return relativeLayout;
    }

    public void setRelativeLayout(Drawable relativeLayout) {
        this.relativeLayout = relativeLayout;
    }

    public String getTitl() {
        return titl;
    }

    public void setTitl(String titl) {
        this.titl = titl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
