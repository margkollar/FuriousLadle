package com.example.myapplication.furiousladle.recycler;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.furiousladle.R;
import com.example.myapplication.furiousladle.models.Recipe;

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

//        RecyclerView recyclerView=findViewById(R.id.recycler);
//        RecyclerAdapter adapter= new RecyclerAdapter(getData());
//        recyclerView.setAdapter(adapter);

    }

    private List<Recipe> getData(){
//        List<Recipe> array=new ArrayList<Recipe>();




        return null;

    }



}
