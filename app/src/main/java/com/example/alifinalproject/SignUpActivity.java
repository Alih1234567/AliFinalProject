package com.example.alifinalproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {
    private TextInputEditText etEmail, etPassword;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignUp = findViewById(R.id.btnSignIn);

        private void checkEmailPassword()
        {
            boolean isALLOK = true;
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            if (email.length() < 6 || email.contains("@") == false) {
                isALLOK = false;
                etEmail.setError("Wrong Email");
            }
            if (password.length() < 8 || password.contains("") == true) {
                isALLOK = false;
                etPassword.setError("Wrong Password");
            }
            if (isALLOK) {
                Toast.makeText(this, "ALL OK", Toast.LENGTH_SHORT).show();

            }

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        };
    }
}