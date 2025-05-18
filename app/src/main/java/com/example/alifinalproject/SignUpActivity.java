package com.example.alifinalproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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
    }
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
                //كائن لعملية التسجبل
                FirebaseAuth auth= FirebaseAuth.getInstance();
                //انشاء حساب بواسطة ايميل وسيسما
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override//התגובה שמתקבל הניסיון הרישום בענן
                    public void onComplete(@NonNull Task<AuthResult> task) {//הפרמטר מכיל מידע מהשרת על תוצאת הבקשה לרישום
                        if(task.isSuccessful()){//اذا كانت عملية التسجيل ناجحة
                            Toast.makeText(SignUpActivity.this, "Signing up Succeeded", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else{
                            Toast.makeText(SignUpActivity.this, "Signing up Failed", Toast.LENGTH_SHORT).show();
                            etEmail.setError(task.getException().getMessage());//عرض الرسالة الخاصة بالخطأ
                        }

                    }
                });


            }


        }
    }
