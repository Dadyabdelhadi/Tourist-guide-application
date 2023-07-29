package com.abdelhadi.vesrion_1_app.common.LoginSingUp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.abdelhadi.vesrion_1_app.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;

public class ForgetPassword extends AppCompatActivity {


    private ImageView screenIcon;
    private TextView title, description;
    private TextInputLayout phoneNumberTextField;
    private CountryCodePicker countryCodePicker;
    private Button nextBtn;
    private Animation animation;
    RelativeLayout progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forget_password);

        screenIcon = findViewById(R.id.forget_password_icon);
        title = findViewById(R.id.forget_password_title);
        description = findViewById(R.id.forget_password_description);
        phoneNumberTextField = findViewById(R.id.forget_password_phone_number);
        countryCodePicker = findViewById(R.id.country_code_picker);
        nextBtn = findViewById(R.id.forget_password_next_btn);


        animation = AnimationUtils.loadAnimation(this, R.anim.side_animation);
//Set animation to all the elements
        screenIcon.setAnimation(animation);
        title.setAnimation(animation);
        description.setAnimation(animation);
        phoneNumberTextField.setAnimation(animation);
        countryCodePicker.setAnimation(animation);
        nextBtn.setAnimation(animation);
    }


    public void callBackScreenFromForgetPassword(View view) {
    }

    public void verifyPhoneNumber(View view) {
        if (!isConnected(this)) {
            showCustomerDialog();
        }


        if (!validatefields()) {
            return;
        }
        progressBar.setVisibility(view.VISIBLE);

        String _phoneNumber = phoneNumberTextField.getEditText().getText().toString().trim();
        if (_phoneNumber.charAt(0) == '0') {
            _phoneNumber = _phoneNumber.substring(1);
        }
        final String _completePhoneNumber = "+" + countryCodePicker.getFullNumber() + _phoneNumber;
        Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("phoneNo").equalTo(_completePhoneNumber);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    phoneNumberTextField.setError(null);
                    phoneNumberTextField.setEnabled(false);
                    Intent intent = new Intent(getApplicationContext(), VerifyOTP.class);
                    intent.putExtra("phoneNo", _completePhoneNumber);
                    intent.putExtra("whattoDO", "updateData");
                    startActivity(intent);
                    finish();
                    progressBar.setVisibility(View.GONE);
                } else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(ForgetPassword.this, "Password does not match", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(ForgetPassword.this, error.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
    }

    private boolean isConnected(ForgetPassword login) {
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

        AlertDialog.Builder builder =new AlertDialog.Builder(ForgetPassword.this);
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
        String phoneNumberTextFieldd = phoneNumberTextField.getEditText().getText().toString().trim();


        if (phoneNumberTextFieldd.isEmpty()) {
            this.phoneNumberTextField.setError("password input cannot be empty");
            return false;
        }
        ////////
        if (phoneNumberTextFieldd.isEmpty()) {
            this.phoneNumberTextField.setError("Phone number cannot be empty");
            return false;
        }
        this.phoneNumberTextField.setError(null);
        return true;
    }

}