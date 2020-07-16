package com.nazycodes.ighubassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Register extends AppCompatActivity {

    private TextInputEditText etFullName;
    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private TextInputEditText etConfirmPassword;
    private MaterialButton btnRegister;
    private TextView txtSignIn;

    private String fullName, email, password, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        txtSignIn = findViewById(R.id.txtSignIn);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullName = etFullName.getText().toString();
                email = etEmail.getText().toString();
                password = etPassword.getText().toString();
                confirmPassword = etConfirmPassword.toString();

                validate();
            }
        });

        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void validate(){
        if (fullName.isEmpty()){
            etFullName.setError("Full Name cannot be empty");
        } else if (email.isEmpty() || !email.contains("@")) {
            etEmail.setError("Email must be valid");
        } else if (password.isEmpty()) {
            etPassword.setError("Password cannot be empty");
        } else if (!password.equals(confirmPassword)) {
            etPassword.setError("Password do not match");
            etConfirmPassword.setError("Password do not match");
        } else {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}