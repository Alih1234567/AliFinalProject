package com.example.alifinalproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AllProductsActivity extends AppCompatActivity {
    private EditText etsearch_bar;
    private Button filter_button;
    private Button wishlist_button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_all_products);
        etsearch_bar = findViewById(R.id.etsearch_bar);
        filter_button = findViewById(R.id.filter_button);
        wishlist_button = findViewById(R.id.wishlist_button);


    }
}