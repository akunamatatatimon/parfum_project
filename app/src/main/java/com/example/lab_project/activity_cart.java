package com.example.lab_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class activity_cart extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CartAdapter adapter;
    private ArrayList<Perfume> cartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.recyclerViewCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cartItems = new ArrayList<>();
        // Populate cartItems with data

        adapter = new CartAdapter(cartItems, this);
        recyclerView.setAdapter(adapter);

        TextView txtTotalAmount = findViewById(R.id.txtTotalAmount);
        txtTotalAmount.setText("Total: " + calculateTotal() + " ₽");

        Button btnPlaceOrder = findViewById(R.id.btnPlaceOrder);
        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Place order logic
            }
        });
    }

    private double calculateTotal() {
        double total = 0.0;
        for (Perfume item : cartItems) {
            total += item.getPrice();
        }
        return total;
    }

    public void updateTotal() {
        TextView txtTotalAmount = findViewById(R.id.txtTotalAmount);
        txtTotalAmount.setText("Total: " + calculateTotal() + " ₽");
    }
}