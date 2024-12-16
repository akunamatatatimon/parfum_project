package com.example.lab_project;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PerfumeAdapter adapter;
    private ArrayList<Perfume> perfumeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewPerfumes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        perfumeList = new ArrayList<>();
        // Populate perfumeList with data

        adapter = new PerfumeAdapter(perfumeList, this);
        recyclerView.setAdapter(adapter);
    }
}