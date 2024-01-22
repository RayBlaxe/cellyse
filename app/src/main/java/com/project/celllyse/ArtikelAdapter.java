package com.project.celllyse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class  ArtikelAdapter extends RecyclerView.Adapter<ArtikelViewHolder>{

    Context context;
    List<ArtikelItem> items;


    public ArtikelAdapter(Context context, List<ArtikelItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ArtikelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArtikelViewHolder(LayoutInflater.from(context).inflate(R.layout.artikel_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArtikelViewHolder holder, int position) {
        holder.judulView.setText(items.get(position).getJudulArtikel());
        holder.isiView.setText(items.get(position).getIsiArtikel());
        holder.imageView.setImageResource(items.get(position).getImgArtikel());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
