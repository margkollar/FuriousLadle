package com.example.myapplication.furiousladle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.furiousladle.models.Recipe;
import com.example.myapplication.furiousladle.recycler.RecyclerActivity;
import com.example.myapplication.furiousladle.recycler.RecyclerAdapter;
import com.example.myapplication.furiousladle.viewmodels.RecipeListener;
import com.example.myapplication.furiousladle.viewmodels.RecipeViewModel;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        EditText userSrh = findViewById(R.id.search);

        userSrh.setOnEditorActionListener(editorListener);

        userSrh.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
//              edo pairno user input
            }
        });
    }

    private TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            switch (actionId) {
                case EditorInfo.IME_ACTION_SEARCH:
                    EditText userSrh = findViewById(R.id.search);

                    String userStr = userSrh.getText().toString();

                    Toast.makeText(Search.this, "Searching", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Search.this, RecyclerActivity.class);
                    startActivity(intent);
                    break;
            }
            return false;
        }
    };

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
//      TODO: test viewmodel
        RecipeViewModel recipeViewModel = new ViewModelProvider(this).get(RecipeViewModel.class);
        EditText searchbox = findViewById(R.id.search);
        String searchTerm = searchbox.getText().toString();
        recipeViewModel.prepareRequest(searchTerm);
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
        }, searchTerm);
    }
}