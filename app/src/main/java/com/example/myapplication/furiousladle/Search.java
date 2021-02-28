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
import android.view.MenuItem;
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
    }

    private TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

            //read insert and search it

            switch (actionId) {
                case EditorInfo.IME_ACTION_SEARCH:

                    EditText userSrh = findViewById(R.id.search);
                    String userStr = String.valueOf(userSrh.getText());

                    Intent intent = new Intent(Search.this, RecyclerActivity.class);

                    //send parameter to next activity
                    Bundle parameter = new Bundle();
                    parameter.putString("searchterm", userStr);
                    intent.putExtras(parameter);
                    startActivity(intent);
                    break;
            }
            return false;
        }
    };

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

}