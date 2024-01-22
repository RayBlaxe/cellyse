package com.project.celllyse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.celllyse.placeholder.PlaceholderContent.PlaceholderItem;



import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 *
 */


public class ArtikelViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView judulView, isiView;;

    public ArtikelViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.fotoartikel);
        judulView = itemView.findViewById(R.id.judul_artikel);
        isiView = itemView.findViewById(R.id.isi_artikel);
    }


}