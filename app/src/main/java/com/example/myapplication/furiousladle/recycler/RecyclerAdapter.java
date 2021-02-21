package com.example.myapplication.furiousladle.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.furiousladle.R;
import com.example.myapplication.furiousladle.RecipeModel;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<RecipeModel> array;

    //constructor:
    public RecyclerAdapter(List<RecipeModel> array){
        this.array=array;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_card,parent,false);

        return new RecyclerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder,int position){
        RecipeModel recipeModel=array.get(position);

        if (holder instanceof RecyclerViewHolder){
            RecyclerViewHolder recyclerViewHolder= (RecyclerViewHolder)holder ;
            recyclerViewHolder.bind(recipeModel);
        }

    }

    @Override
    public int getItemCount(){
        return array.size();
    }


}
