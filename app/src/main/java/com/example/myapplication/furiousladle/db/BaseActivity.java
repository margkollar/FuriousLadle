package com.example.myapplication.furiousladle.db;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.furiousladle.R;

import java.util.List;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);


    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        //ama de valoume counter ti egine????

        handleDatabase();


    }

    private void handleDatabase() {

        UserEntity entity = new UserEntity(1, "Soula", "Skylaki", "soula", "soula", "kotoula");
        new UserEntityAsyncTask(getApplicationContext()).execute(entity);

        new UserGetEntityAsyncTask(getApplicationContext(), new UserEntityListener() {
            @Override
            public void onSuccessResult(List<UserEntity> array) {
                Log.d("Database", String.valueOf(array));
            }
        }).execute();


    }
}

