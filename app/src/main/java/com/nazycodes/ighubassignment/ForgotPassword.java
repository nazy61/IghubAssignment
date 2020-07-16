package com.nazycodes.ighubassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class ForgotPassword extends AppCompatActivity {

    private TextInputEditText etResetEmail;
    private MaterialButton btnReset;

    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        etResetEmail = findViewById(R.id.etResetEmail);
        btnReset = findViewById(R.id.btnReset);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = etResetEmail.getText().toString().trim();

                validate();
            }
        });
    }

    private void validate() {
        if(email.isEmpty() || !email.contains("@")){
            etResetEmail.setError("email must be valid");
        } else {
            Toast.makeText(getApplicationContext(), "Password Reset Sent Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}