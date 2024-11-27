package com.example.a2fa_class;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText inputFieldEmail, inputFieldPassword;
    private String userEmail;
    private Button loginButton;
    @Override
    protected void onCreate(Bundle setBundle){
        super.onCreate(setBundle);
        setContentView(R.layout.activity_login);

        inputFieldEmail = findViewById(R.id.editTextEmail);
        inputFieldPassword = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.buttonLogIn);

        loginButton.setOnClickListener(v->{
             userEmail = inputFieldEmail.getText().toString();
            String userPassword = inputFieldPassword.getText().toString();

            if(validateCredentials(userEmail,userPassword)){
                Toast.makeText(this, "Valid Credentials",Toast.LENGTH_SHORT).show();
                navigateToOtp();
            }
            else{
                Toast.makeText(this, "Invalid Credentials",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public boolean validateCredentials(String email, String password){
        return email.equals("darisdragusha@gmail.com") && password.equals("password");
    }
    public void navigateToOtp(){
        Intent intent = new Intent(this, OtpActivity.class);
        intent.putExtra("recipiant",userEmail);
        startActivity(intent);
    }
}
