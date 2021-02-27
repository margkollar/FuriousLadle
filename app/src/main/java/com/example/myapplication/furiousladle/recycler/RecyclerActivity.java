package com.example.myapplication.furiousladle.recycler;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.furiousladle.LoginActivity;
import com.example.myapplication.furiousladle.Profile;
import com.example.myapplication.furiousladle.ProfileFragment;
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
                Toast.makeText(RecyclerActivity.this, "No results, please try again", Toast.LENGTH_SHORT).show();
            }
        }, theTerm);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        // return true so that the menu pop up is opened
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.profil) {
            ProfileFragment fragment = new ProfileFragment();
            fragment.show(getSupportFragmentManager(), "TAG");

        }
        return super.onOptionsItemSelected(item);
    }



}
