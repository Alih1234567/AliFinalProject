package com.example.alifinalproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ProphileActivity2 extends AppCompatActivity {

private EditText etName;
private EditText etEmail;
private  EditText etphone_number;
private EditText etpreferred_sports;
private Button btnAdd_profile;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         EdgeToEdge.enable(this);
         setContentView(R.layout.activity_prophile2);

         etName = findViewById(R.id.etName);
         etEmail = findViewById(R.id.etEmail);
         etphone_number = findViewById(R.id.etphone_number);
         etpreferred_sports = findViewById(R.id.etpreferred_sports);
         btnAdd_profile = findViewById(R.id.btnAdd_profile);


     }

     private void readAndValidateFields() {
         String name = etName.getText().toString().trim();
         String email = etEmail.getText().toString().trim();
         String phone_number = etphone_number.getText().toString().trim();
         String preferred_sports = etpreferred_sports.getText().toString().trim();

         if (name.isEmpty()) {
             etName.setError("Name cannot be empty");
             return;
         }

         if (email.isEmpty() || !email.contains("@")) {
             etEmail.setError("Invalid email");
             return;
         }

         if (phone_number.length() < 11) {
             etphone_number.setError("Invalid phone number");
             return;
         }

         if (preferred_sports.isEmpty()) {
             etpreferred_sports.setError("Preferred sports cannot be empty");
             return;
         }

        // If all fields are valid, proceed with your logic
         Toast.makeText(this, "All fields are valid", Toast.LENGTH_SHORT).show();
     }
}