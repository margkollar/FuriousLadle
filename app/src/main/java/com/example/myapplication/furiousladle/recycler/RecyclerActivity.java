package com.example.myapplication.furiousladle.recycler;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.furiousladle.R;
import com.example.myapplication.furiousladle.models.Recipe;
import com.example.myapplication.furiousladle.viewmodels.RecipeListener;
import com.example.myapplication.furiousladle.viewmodels.RecipeViewModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_layout);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        Bundle parameters = getIntent().getExtras();
        RecipeViewModel recipeViewModel = new ViewModelProvider(this).get(RecipeViewModel.class);
        String theTerm = parameters.getString("searchterm");
        recipeViewModel.retrieveRecipe(new RecipeListener() {
            @Override
            public void onSuccessResponse(List<Recipe> data) {
                RecyclerView recyclerView=findViewById(R.id.recycler);
                RecyclerAdapter adapter= new RecyclerAdapter(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onErrorResponse(String data) {

            }
        }, theTerm);



    }




}
