package com.example.myapplication.furiousladle.recycler;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.furiousladle.LoginActivity;
import com.example.myapplication.furiousladle.R;
import com.example.myapplication.furiousladle.models.Recipe;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private static final String EMPTY_STRING = "";

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
    }


    public void bind(Recipe r) {
        TextView texTitle = itemView.findViewById(R.id.holder_title);
        texTitle.setText(r.getTitle());

        TextView textViewDescr = itemView.findViewById(R.id.holder_dec);


        ImageView img = itemView.findViewById(R.id.holder_img);
        Glide.with(this.itemView).load(r.getImageURL()).into(img);

        TextView ingredients = itemView.findViewById(R.id.holder_ingred);
        textViewDescr.setText(r.getOwner());

        String ingr = EMPTY_STRING;
        for (String ingredient : r.getIngredients()) {
            ingr = ingr + "\n" + ingredient;
        }
        ingredients.setText(ingr);

        TextView viewMore = itemView.findViewById(R.id.holder_details);
        viewMore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(r.getExternalURL()));
                ContextCompat.startActivity(v.getContext(), intent, null);
            }
        });
    }
}
