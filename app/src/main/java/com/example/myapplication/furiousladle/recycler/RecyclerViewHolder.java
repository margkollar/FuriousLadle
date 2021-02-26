package com.example.myapplication.furiousladle.recycler;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
import com.example.myapplication.furiousladle.Search;
import com.example.myapplication.furiousladle.WebBrowser;
import com.example.myapplication.furiousladle.models.Recipe;

import static androidx.core.content.ContextCompat.startActivity;

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
        ingredients.setMovementMethod(new ScrollingMovementMethod());

        Button viewMore = itemView.findViewById(R.id.holder_details);
        viewMore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                old external browser code

//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(r.getExternalURL()));
//                startActivity(v.getContext(), intent, null);

//              internal browser code
                Intent intent = new Intent(v.getContext(), WebBrowser.class);
                Bundle parameter = new Bundle();
                parameter.putString("theURL", r.getExternalURL());
                intent.putExtras(parameter);
                startActivity(v.getContext(), intent, null);
            }
        });

        Button shareBtn = itemView.findViewById(R.id.holder_share);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, r.getExternalURL());
                Intent shareIntent = Intent.createChooser(intent, null);

                startActivity(v.getContext(), shareIntent, null);

            }
        });
    }



}
