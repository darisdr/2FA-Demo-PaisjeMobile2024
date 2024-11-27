package com.example.a2fa_class;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OtpActivity extends AppCompatActivity {
    private EditText inputFieldOtp;
    private Button validateOtpButton, resendOtpButton;
    String recipiant;

    @Override
    protected void onCreate(Bundle setBundle){
        super.onCreate(setBundle);
        setContentView(R.layout.activity_otp);

        inputFieldOtp = findViewById(R.id.editTextNumber);
        validateOtpButton = findViewById(R.id.buttonOtp);
        resendOtpButton = findViewById(R.id.buttonResend);



        String recipiant = getIntent().getStringExtra("recipiant");
        String generatedOtp = generateOtp();
        EmailService.sendEmail(recipiant, "Your One Time Password", generatedOtp);
        validateOtpButton.setOnClickListener(v->{
            String userOtp = inputFieldOtp.getText().toString();
            if(userOtp.equals( generatedOtp)){
                Toast.makeText(this, "Success",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }

        });
        resendOtpButton.setOnClickListener(v->{
            Intent intent = new Intent(this, OtpActivity.class);
            intent.putExtra("recipiant",recipiant);
            startActivity(intent);

        });


    }
    public String generateOtp(){
        int generatedOtp = (int)(Math.random()*1000000);
        return String.valueOf(generatedOtp);
    }
}
