package com.example.myapplication.furiousladle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.myapplication.furiousladle.db.InsertCallbackListener;
import com.example.myapplication.furiousladle.db.InsertUserAsyncTask;
import com.example.myapplication.furiousladle.db.UserEntity;
import com.example.myapplication.furiousladle.db.UserEntityAsyncTask;

public class Splash extends AppCompatActivity {
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //read app preferences  (isInserted)
        preferences = this.getSharedPreferences("flprefs", MODE_PRIVATE);
        Boolean isInserted = preferences.getBoolean("isInserted", false);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(isInserted == false){
                    doInsert(new InsertCallbackListener() {
                        @Override
                        public void onSuccessResult() {

                            //set isInserted true
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putBoolean("isInserted", true);
                            editor.apply();

                            //send to Login
                            Intent intent = new Intent(Splash.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }else{
                    Intent intent = new Intent(Splash.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }



            }

        }, 3000);

    }
    //insert user to the DataBase
    private void doInsert(InsertCallbackListener listener){
        //TODO id autoincrement thelei null ????
        UserEntity entity = new UserEntity("furious", "ladle", "furious",
                "ladle", "God forsaken Glutton, likes junk food sweets and hates like hell the gym.");
        new InsertUserAsyncTask(this,listener).execute(entity);
        }

    }
