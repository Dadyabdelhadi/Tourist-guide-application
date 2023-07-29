package com.abdelhadi.vesrion_1_app.common.LoginSingUp;

import static com.abdelhadi.vesrion_1_app.R.id.country_code_picker;
import static com.hbb20.R.id.countryCodeHolder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.ScrollView;

import com.abdelhadi.vesrion_1_app.R;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class SignUp3rdClass extends AppCompatActivity {

    ScrollView scrollView;
    TextInputLayout phoneNumber;
    CountryCodePicker countryCodePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up3rd_class);


        scrollView =findViewById(R.id.signup_3rd_screen_scroll_view);
        countryCodePicker =findViewById(R.id.country_code_picker);
        phoneNumber =findViewById(R.id.signup_phone_number);

    }

    public void callVerifyOTPScreen(View view) {
        if(!validatePhoneNumber()){
            return;
        }
        Intent intent = new Intent(getApplicationContext(), VerifyOTP.class);

        String _fullName = getIntent().getStringExtra("fullName");
        String _email = getIntent().getStringExtra("email");
        String _username = getIntent().getStringExtra("username");
        String _password = getIntent().getStringExtra("password");
        String _date = getIntent().getStringExtra("date");
        String _gender = getIntent().getStringExtra("gender");



        String countryCode = countryCodePicker.getSelectedCountryCode();
        String userEnteredPhoneNumber = phoneNumber.getEditText().getText().toString().trim();
        String _phoneNo = userEnteredPhoneNumber;



        //Pass all fields to the next activity
        intent.putExtra("fullName", _fullName);
        intent.putExtra("email", _email);
        intent.putExtra("username", _username);
        intent.putExtra("password", _password);
        intent.putExtra("date", _date);
        intent.putExtra("gender", _gender);
        intent.putExtra("phoneNo", _phoneNo);
        //Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(scrollView, "transition_OTP_screen");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp3rdClass.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }

    private boolean validatePhoneNumber() {
        String phoneNumber = this.phoneNumber.getEditText().getText().toString().trim();
        if (phoneNumber.isEmpty()) {
            this.phoneNumber.setError("Phone number cannot be empty");
            return false;
        }
        String regexPattern = "^[+]?[0-9]{10,13}$";
        if (!phoneNumber.matches(regexPattern)) {
            this.phoneNumber.setError("Invalid phone number format");
            return false;
        }
        this.phoneNumber.setError(null);
        return true;
    }


    public void callLoginScreen(View view) {
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }
}
/*
public void callVerifyOTPScreen(View view) {
    if (!validatePhoneNumber()) {
        return;
    }

    Intent intent = new Intent(this, VerifyOTP.class);
    intent.putExtras(getIntent().getExtras());

    // Get complete phone number
    String countryCode = countryCodePicker.getSelectedCountryCode();
    String userEnteredPhoneNumber = phoneNumber.getEditText().getText().toString().trim();
    String phoneNo = "+" + countryCode + userEnteredPhoneNumber;

    // Pass phone number to the next activity
    intent.putExtra("phoneNo", phoneNo);

    // Add transition
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        View sharedElement = scrollView;
        String transitionName = getString(R.string.transition_OTP_screen);
        Pair<View, String> pair = Pair.create(sharedElement, transitionName);
        ActivityOptions options = ActivityOptions
            .makeSceneTransitionAnimation(this, pair);
        startActivity(intent, options.toBundle());
    } else {
        startActivity(intent);
    }
}

private boolean validatePhoneNumber() {
    String phoneNumber = this.phoneNumber.getEditText().getText().toString().trim();
    if (phoneNumber.isEmpty()) {
        this.phoneNumber.setError("Phone number cannot be empty");
        return false;
    }
    String regexPattern = "^[+]?[0-9]{10,13}$";
    if (!phoneNumber.matches(regexPattern)) {
        this.phoneNumber.setError("Invalid phone number format");
        return false;
    }
    this.phoneNumber.setError(null);
    return true;
}
 */