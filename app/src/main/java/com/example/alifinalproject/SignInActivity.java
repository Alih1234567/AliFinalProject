package com.example.alifinalproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
private EditText etEmail, etPassword;
private Button btnSignIn;
private Button btnSignUp;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInputs();
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        btnSignIn = findViewById(R.id.btnSignIn);
btnSignIn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        validateInputs();
        Intent intent = new Intent(SignInActivity.this, AllProductsActivity.class);
        startActivity(intent);
    }
});

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
        //كائن لعملية التسجبل
        FirebaseAuth auth= FirebaseAuth.getInstance();
        //الدخول للحساب بواسطة ايميل وسيسما
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override//هذه الدالة يتم تنفيذها بعد الانتهاء من عملية التسجيل
            public void onComplete(@NonNull Task<AuthResult> task) {//הפרמטר מכיל מידע מהשרת על תוצאת הבקשה לרישום
                if(task.isSuccessful()){//اذا كانت عملية التسجيل ناجحة
                    Toast.makeText(SignInActivity.this, "Signing in Succeeded", Toast.LENGTH_SHORT).show();
                    //الانتقال للصفحة الرئيسية
                    Intent i= new Intent(SignInActivity.this, AllProductsActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(SignInActivity.this, "Signing in Failed", Toast.LENGTH_SHORT).show();
                    etEmail.setError(task.getException().getMessage());//عرض الرسالة الخاصة بالخطأ
                }
            }
        });


    }
}
}