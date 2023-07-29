package com.abdelhadi.vesrion_1_app.common.LoginSingUp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.abdelhadi.vesrion_1_app.R;
import com.abdelhadi.vesrion_1_app.common.Data.UserHelperClass;
import com.chaos.view.PinView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class VerifyOTP extends AppCompatActivity {
    String codeBySystem;
    PinView pinFromUser;
   
    TextView otpDescriptionText;
    String fullName, phoneNo, email, username, password, date, gender, whatToDO;
    // [NEWLY Updated code  --  START declare_mAuth]
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_verify_otp);
        //hooks
        pinFromUser = findViewById(R.id.pin_view);
        otpDescriptionText = findViewById(R.id.otp_description_text);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        //Get all the data from Intent
        fullName = getIntent().getStringExtra("fullName");
        email = getIntent().getStringExtra("email");
        username = getIntent().getStringExtra("username");
        password = getIntent().getStringExtra("password");
        date = getIntent().getStringExtra("date");
        gender = getIntent().getStringExtra("gender");
        phoneNo = getIntent().getStringExtra("phoneNo");
        whatToDO = getIntent().getStringExtra("whatToDO");
        otpDescriptionText.setText("Enter One Time Password Sent Onn"+phoneNo);
        sendVerificationCodeToUser(phoneNo);
    }

    private void sendVerificationCodeToUser(String phoneNo) {
        // [START start_phone_auth]
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(mAuth) //mAuth is defined on top
                .setPhoneNumber(phoneNo)       // Phone number to verify
                .setTimeout(80L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(this)                 // Activity (for callback binding)
                .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
        // [END start_phone_auth]
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks =
            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                @Override
                public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                    super.onCodeSent(s, forceResendingToken);
                    codeBySystem = s;
                }
                @Override
                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                    String code = phoneAuthCredential.getSmsCode();
                    if (code != null) {
                        pinFromUser.setText(code);
                        verifyCode(code);
                    }
                }
                @Override
                public void onVerificationFailed(@NonNull FirebaseException e) {
                    Toast.makeText(VerifyOTP.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            };

    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeBySystem, code);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            if (whatToDO.equals("updateData")) {
                                updateOldUsersData();
                            } else if (whatToDO.equals("createNewUser")) {
                                storeNewUsersData();
                            }
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(VerifyOTP.this, "Verification Not Completed! Try again.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

    private void updateOldUsersData() {
        Intent intent =new Intent(getApplicationContext(),SetNewPassword.class);
        intent.putExtra("phoneNo",phoneNo);
        startActivity(intent);
        finish();
    }

    private void storeNewUsersData() {
        FirebaseDatabase rootNode =FirebaseDatabase.getInstance();
        DatabaseReference reference  =rootNode.getReference("Users");

        UserHelperClass addNewuser =new UserHelperClass(fullName,username,email,phoneNo,password,date,gender);
        reference.child(phoneNo).setValue(addNewuser);
        reference.setValue(addNewuser);
    }

    public void callNextScreenFromOTP(View view) {
        String code =pinFromUser.getText().toString();
        if(!code.isEmpty()){
            verifyCode(code);
        }
    }

    public void goToHomeFromOTP(View view) {
    }
}