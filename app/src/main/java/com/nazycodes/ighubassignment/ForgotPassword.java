package com.nazycodes.ighubassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    private static final String TAG = "ForgotPassword";

    private TextInputEditText etResetEmail;
    private CardView cvReset;
    private ProgressBar pbLoading;

    private String email;

    private FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        etResetEmail = findViewById(R.id.etResetEmail);
        cvReset = findViewById(R.id.cvReset);
        pbLoading = findViewById(R.id.pbLoading);

        cvReset.setOnClickListener(new View.OnClickListener() {
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
            pbLoading.setVisibility(View.VISIBLE);
            sendEmailLink();
        }
    }

    private void sendEmailLink() {
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            pbLoading.setVisibility(View.INVISIBLE);
                            Log.d(TAG, "Email sent. Check Your Email Address.");
                        } else {
                            pbLoading.setVisibility(View.INVISIBLE);
                            Log.w(TAG, "Error in sending Reset Mail", task.getException());
                            Toast.makeText(getApplicationContext(), "Error in sending Reset Mail",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}