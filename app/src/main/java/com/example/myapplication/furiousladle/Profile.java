package com.example.myapplication.furiousladle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.example.myapplication.furiousladle.db.UserDatabase;
import com.example.myapplication.furiousladle.db.UserEntity;
import com.example.myapplication.furiousladle.db.UserProfileAsyncTask;
import com.example.myapplication.furiousladle.db.UserProfileCallback;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        UserDatabase userDatabase= Room.databaseBuilder(this, UserDatabase.class,"furious_ladle_db")
                .build();
        new UserProfileAsyncTask(new UserProfileCallback() {
            @Override
            public void onSuccessResult(UserEntity entity) {

                fillProfileCard(entity);
            }
        }, userDatabase).execute();
    }

    private void fillProfileCard(UserEntity user){

    }
}