package com.example.lab_project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private ArrayList<Perfume> cartItems;
    private Context context;

    public CartAdapter(ArrayList<Perfume> cartItems, Context context) {
        this.cartItems = cartItems;
        this.context = context;
    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(CartViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Perfume perfume = cartItems.get(position);
        holder.txtPerfumeName.setText(perfume.getName());
        holder.txtPrice.setText(perfume.getPrice() + " ₽");
        // Load image using Glide or Picasso

        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartItems.remove(position);
                notifyItemRemoved(position);
                // Update total amount
                ((activity_cart) context).updateTotal();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgPerfume;
        public TextView txtPerfumeName;
        public TextView txtPrice;
        public ImageButton btnRemove;

        public CartViewHolder(View itemView) {
            super(itemView);
            imgPerfume = itemView.findViewById(R.id.imgPerfumeCart);
            txtPerfumeName = itemView.findViewById(R.id.txtPerfumeNameCart);
            txtPrice = itemView.findViewById(R.id.txtPriceCart);
            btnRemove = itemView.findViewById(R.id.btnRemove);
        }
    }
}