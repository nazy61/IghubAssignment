package com.nazycodes.ighubassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private TextView txtSignUp;
    private TextView txtForgotPassword;
    private MaterialButton btnLogin;

    private String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        txtSignUp = findViewById(R.id.txtSignUp);
        txtForgotPassword = findViewById(R.id.txtForgotPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = etEmail.getText().toString().trim();
                password = etPassword.getText().toString().trim();

                validate();
            }
        });

        txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgotPassword.class);
                startActivity(intent);
            }
        });

        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
    }

    private void validate(){
        if(email.isEmpty()){
            etEmail.setError("email cannot be empty!");
        } else if (password.isEmpty() || password.length() < 4) {
            etPassword.setError("Password cannot be less than 4 characters!");
        } else {
            Toast.makeText(getApplicationContext(), "Credentials successfully validated", Toast.LENGTH_LONG).show();
        }
    }
}