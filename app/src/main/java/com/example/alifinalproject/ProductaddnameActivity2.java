package com.example.alifinalproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ProductaddnameActivity2 extends AppCompatActivity {

private EditText etProName;
private EditText etDesc;
private EditText etPrice;
private Button btnPostPro;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         EdgeToEdge.enable(this);
         setContentView(R.layout.activity_productname2);

         etProName = findViewById(R.id.etProName);
         etDesc = findViewById(R.id.etDesc);
         etPrice = findViewById(R.id.etPrice);
         btnPostPro = findViewById(R.id.btnPostPro);

     }
private void readAndValidateFields() {
    String productName = etProName.getText().toString().trim();
    String productDescription = etDesc.getText().toString().trim();
    String productPriceStr = etPrice.getText().toString().trim();

    if (productName.isEmpty()) {
        etProName.setError("Product name cannot be empty");
        return;
    }

    if (productDescription.isEmpty()) {
        etDesc.setError("Product description cannot be empty");
        return;
    }

    double productPrice;
    try {
        productPrice = Double.parseDouble(productPriceStr);
        if (productPrice <= 0) {
            etPrice.setError("Product price must be greater than zero");
            return;
        }
    } catch (NumberFormatException e) {
        etPrice.setError("Invalid price format");
        return;
    }

    // If all fields are valid, proceed with your logic
    Toast.makeText(this, "All fields are valid", Toast.LENGTH_SHORT).show();
}




     }

