package com.example.myapplication.furiousladle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

//                fillProfileCard(entity);
                TextView name = findViewById(R.id.name);
                TextView userName = findViewById(R.id.username);
                TextView bio = findViewById(R.id.bio);

                name.setText(entity.getFirst_name() + " " + entity.getLast_name());
                userName.setText(entity.getUsername());
                bio.setText(entity.getBio());
            }
        }, userDatabase).execute();

    }

    private void fillProfileCard(UserEntity user){
//        TextView name = findViewById(R.id.name);
//        TextView userName = findViewById(R.id.name);
//        TextView bio = findViewById(R.id.name);
//
//        name.setText(user.getFirst_name() + " " + user.getLast_name());
//        userName.setText(user.getUsername());
//        bio.setText(user.getBio());
    }
}