package com.example.lab_project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab_project.R;

import java.util.ArrayList;

public class PerfumeAdapter extends RecyclerView.Adapter<PerfumeAdapter.PerfumeViewHolder> {
    private final ArrayList<Perfume> perfumeList;
    private final Context context;

    public PerfumeAdapter(ArrayList<Perfume> perfumeList, Context context) {
        this.perfumeList = perfumeList;
        this.context = context;
    }

    @Override
    public PerfumeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_perfume, parent, false);
        return new PerfumeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PerfumeViewHolder holder, int position) {
        Perfume perfume = perfumeList.get(position);
        holder.txtPerfumeName.setText(perfume.getName());
        holder.txtPerfumeBrand.setText(perfume.getBrand());
        // Load image using Glide or Picasso
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PerfumeDetailsActivity.class);
                intent.putExtra("perfume", perfume);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return perfumeList.size();
    }

    public static class PerfumeViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgPerfume;
        public TextView txtPerfumeName;
        public TextView txtPerfumeBrand;

        public PerfumeViewHolder(View itemView) {
            super(itemView);
            imgPerfume = itemView.findViewById(R.id.imgPerfume);
            txtPerfumeName = itemView.findViewById(R.id.txtPerfumeName);
            txtPerfumeBrand = itemView.findViewById(R.id.txtPerfumeBrand);
        }
    }
}