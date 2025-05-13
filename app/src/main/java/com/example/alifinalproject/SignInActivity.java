package com.example.alifinalproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignInActivity extends AppCompatActivity {
private EditText etEmail, etPassword;
private Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = findViewById(R.id.btnSignIn);

    }
private void validateInputs() {
    boolean isValid = true;
    String email = etEmail.getText().toString().trim();
    String password = etPassword.getText().toString().trim();

    // Check email validity
    if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
        isValid = false;
        etEmail.setError("Invalid Email");
    }

    // Check password validity
    if (password.isEmpty() || password.length() < 8) {
        isValid = false;
        etPassword.setError("Invalid Password");
    }

    if (isValid) {
        Toast.makeText(this, "All inputs are valid", Toast.LENGTH_SHORT).show();

    }
}
}