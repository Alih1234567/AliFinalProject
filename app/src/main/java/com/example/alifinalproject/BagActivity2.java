package com.example.alifinalproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BagActivity2 extends AppCompatActivity {
    private Button btnRemove;
    private Button btnBuy;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bag2);

        btnRemove = findViewById(R.id.btnRemove);
        btnBuy = findViewById(R.id.btnBuy);

    }
}