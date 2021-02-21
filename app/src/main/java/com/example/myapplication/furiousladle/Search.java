package com.example.myapplication.furiousladle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.furiousladle.recycler.RecyclerActivity;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        EditText userSrh = findViewById(R.id.search);
        String userStr = userSrh.getText().toString();
        userSrh.setOnEditorActionListener(editorListener);
    }
         private TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId) {
                    case EditorInfo.IME_ACTION_SEARCH:
                        Toast.makeText(Search.this, "Searching", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Search.this, RecyclerActivity.class);
                        startActivity(intent);
                        break;
                }
                return false;
            }
        };


}