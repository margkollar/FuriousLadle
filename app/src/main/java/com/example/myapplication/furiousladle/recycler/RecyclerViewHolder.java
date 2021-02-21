package com.example.myapplication.furiousladle.recycler;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.furiousladle.R;
import com.example.myapplication.furiousladle.RecipeModel;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public RecyclerViewHolder(@NonNull View itemView){
        super(itemView);
    }


    public void bind(RecipeModel r){
        TextView texTitle= itemView.findViewById(R.id.holder_title);
        texTitle.setText(r.getRecipe());

        TextView textViewDescr=itemView.findViewById(R.id.holder_dec);
        textViewDescr.setText(r.getDescr());

        ImageView img=itemView.findViewById(R.id.holder_img);
       //tha to doyme: img.setKati..... apo string url ..........








    }
}
