package com.example.myapplication.furiousladle.recycler;


import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.furiousladle.R;
import com.example.myapplication.furiousladle.models.Recipe;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public RecyclerViewHolder(@NonNull View itemView){
        super(itemView);
    }


    public void bind(Recipe r){
        TextView texTitle= itemView.findViewById(R.id.holder_title);
        texTitle.setText(r.getTitle());

        TextView textViewDescr=itemView.findViewById(R.id.holder_dec);
        textViewDescr.setText(r.getOwner());

        ImageView img=itemView.findViewById(R.id.holder_img);
        Glide.with(this.itemView).load(r.getImageURL()).into(img);








    }
}
