package com.abdelhadi.vesrion_1_app.common.Data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class CheckInternet {

    public  boolean isCnnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiConn =connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn =connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if ((wifiConn != null && wifiConn.isConnected())|| (mobileConn !=null && mobileConn.isConnected())){
            return  true;
        }
        else {
            return false;
        }
    }
}
