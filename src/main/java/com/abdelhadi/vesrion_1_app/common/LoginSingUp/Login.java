package com.abdelhadi.vesrion_1_app.common.LoginSingUp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.abdelhadi.vesrion_1_app.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;

public class Login extends AppCompatActivity {

    CountryCodePicker countryCodePicker;
    TextInputLayout phoneNumber, password;
    RelativeLayout progressbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retiared_login);
        countryCodePicker = findViewById(R.id.login_country_code_picker);
        phoneNumber = findViewById(R.id.login_password);
        progressbar = findViewById(R.id.login_progress_bar);
    }

    public void letTheUserLoggedIn(View view) {
        if (!isConnected(this)){
            showCustomerDialog();
        }


        if (!validatefields()) {
            return;
        }
        progressbar.setVisibility(view.VISIBLE);

        String _phoneNumber = phoneNumber.getEditText().getText().toString().trim();
        String _password = password.getEditText().getText().toString().trim();
        if (_phoneNumber.charAt(0) == '0') {
            _phoneNumber = _phoneNumber.substring(1);
        }
        String _completePhoneNumber = "+" + countryCodePicker.getFullNumber() + _phoneNumber;
        Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("phoneNo").equalTo(_completePhoneNumber);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    phoneNumber.setError(null);
                    phoneNumber.setEnabled(false);
                    String systemPassword = snapshot.child(_completePhoneNumber).child("password").getValue(String.class);
                    if (systemPassword.equals(_password)) {
                        password.setError(null);
                        password.setErrorEnabled(false);

                        String _fullname = snapshot.child(_completePhoneNumber).child("fullName").getValue(String.class);
                        String _email = snapshot.child(_completePhoneNumber).child("email").getValue(String.class);
                        String _phoneNo = snapshot.child(_completePhoneNumber).child("phoneNo").getValue(String.class);
                        String _dateOFbirth = snapshot.child(_completePhoneNumber).child("date").getValue(String.class);

                        Toast.makeText(Login.this,_fullname+"\n"+_email+"\n"+_phoneNo+"\n"+_dateOFbirth, Toast.LENGTH_SHORT).show();
                    } else {
                        progressbar.setVisibility(View.GONE);
                        Toast.makeText(Login.this, "Password does not match", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    progressbar.setVisibility(View.GONE);
                    Toast.makeText(Login.this, "No such user exist", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressbar.setVisibility(View.GONE);
                Toast.makeText(Login.this, error.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        /*

        String countryCode = countryCodePicker.getSelectedCountryCode();
        String userEnteredPhoneNumber = phoneNumber.getEditText().getText().toString().trim();
        String _phoneNo = userEnteredPhoneNumber;*/
    }


    private boolean isConnected(Login login) {
        ConnectivityManager connectivityManager = (ConnectivityManager) login.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiConn =connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn =connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if ((wifiConn != null && wifiConn.isConnected())|| (mobileConn !=null && mobileConn.isConnected())){
            return  true;
        }
        else {
            return false;
        }
    }


    private void showCustomerDialog() {

        AlertDialog.Builder builder =new AlertDialog.Builder(Login.this);
        builder.setMessage("Please connect to the internet to proceed futher")
                .setCancelable(false)
                .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Settings.ACTION_WIFI_IP_SETTINGS));
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(),RetialerStartUpScreen.class));
                        finish();

                    }
                });

    }

    private boolean validatefields() {
        String _phoneNumber = phoneNumber.getEditText().getText().toString().trim();
        String _password = password.getEditText().getText().toString().trim();


        if (_password.isEmpty()) {
            this.phoneNumber.setError("password input cannot be empty");
            return false;
        }
        ////////
        if (_phoneNumber.isEmpty()) {
            this.phoneNumber.setError("Phone number cannot be empty");
            return false;
        }
        this.password.setError(null);
        this.phoneNumber.setError(null);
        return true;
    }

    public void callForgetPassword(View view) {
        startActivity(new Intent(getApplicationContext(), ForgetPassword.class));
        finish();
    }

    public void callSignUpFromLogin(View view) {
        startActivity(new Intent(getApplicationContext(), SiningUp.class));
        finish();
    }
}