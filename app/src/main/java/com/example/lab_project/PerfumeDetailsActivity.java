package com.example.lab_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PerfumeDetailsActivity extends AppCompatActivity {
    private Perfume perfume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfume_details);

        perfume = (Perfume) getIntent().getSerializableExtra("perfume");

        // Populate UI with perfume details
        ImageView imgPerfumeDetail = findViewById(R.id.imgPerfumeDetail);
        imgPerfumeDetail.setImageResource(perfume.getImageRes());
        TextView txtPerfumeNameDetail = findViewById(R.id.txtPerfumeNameDetail);
        txtPerfumeNameDetail.setText(perfume.getName());
        // ... and so on for other views

        Button btnAddToCart = findViewById(R.id.btnAddToCart);
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add to cart logic
            }
        });

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}