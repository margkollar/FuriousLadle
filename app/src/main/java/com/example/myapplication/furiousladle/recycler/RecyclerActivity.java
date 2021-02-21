package com.example.myapplication.furiousladle.recycler;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.furiousladle.R;
import com.example.myapplication.furiousladle.RecipeModel;

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

        RecyclerView recyclerView=findViewById(R.id.recycler);
        RecyclerAdapter adapter= new RecyclerAdapter(getData());
        recyclerView.setAdapter(adapter);

    }

    private List<RecipeModel> getData(){
        List<RecipeModel> array=new ArrayList<RecipeModel>();
        //tra la la gemizoyme kapwsssssss ti lista
        //oxi karfwta omws.............................

        //proxeira na doume an douleyei :
        array.add(new RecipeModel("mousakas","melitzanes kai mpesamel","url1"));
        array.add(new RecipeModel("pastitso","makaronia kai mpesamel","url2"));
        array.add(new RecipeModel("makaronada","makaronia kai kimas","url3"));
        array.add(new RecipeModel("mousakas","melitzanes kai mpesamel","url1"));
        array.add(new RecipeModel("pastitso","makaronia kai mpesamel","url2"));
        array.add(new RecipeModel("makaronada","makaronia kai kimas","url3"));
        array.add(new RecipeModel("mousakas","melitzanes kai mpesamel","url1"));
        array.add(new RecipeModel("pastitso","makaronia kai mpesamel","url2"));
        array.add(new RecipeModel("makaronada","makaronia kai kimas","url3"));
        array.add(new RecipeModel("mousakas","melitzanes kai mpesamel","url1"));
        array.add(new RecipeModel("pastitso","makaronia kai mpesamel","url2"));
        array.add(new RecipeModel("makaronada","makaronia kai kimas","url3"));
        array.add(new RecipeModel("mousakas","melitzanes kai mpesamel","url1"));
        array.add(new RecipeModel("pastitso","makaronia kai mpesamel","url2"));
        array.add(new RecipeModel("makaronada","makaronia kai kimas","url3"));


        return array;

    }



}
