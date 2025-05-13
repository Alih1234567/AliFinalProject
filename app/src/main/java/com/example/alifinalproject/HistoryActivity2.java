package com.example.alifinalproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HistoryActivity2 extends AppCompatActivity {
    private TextView tvHome;
    private TextView tvWishList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history2);
        tvHome = findViewById(R.id.tvHome);
        tvWishList = findViewById(R.id.tvWishList);

tvHome.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v)
    {
        startActivity(new Intent(HistoryActivity2.this, AllProductsActivity.class));
        // Your code here
    }
});

tvWishList.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // Your code here
    }
});


    }
}