package com.abdelhadi.vesrion_1_app.ClassHelper.HomeAdapter;


import android.graphics.drawable.Drawable;

public class MostViewedHelperClass {
    Drawable relativeLayout;
    String titl,desc;

    public MostViewedHelperClass(Drawable relativeLayout, String titl, String desc) {
        this.relativeLayout = relativeLayout;
        this.titl = titl;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
