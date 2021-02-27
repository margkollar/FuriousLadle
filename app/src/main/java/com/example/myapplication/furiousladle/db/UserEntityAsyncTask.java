package com.example.myapplication.furiousladle.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

public class UserEntityAsyncTask extends AsyncTask<UserEntity,UserEntity,Boolean> {
    UserDatabase userDatabase;

    public UserEntityAsyncTask(Context context){
        userDatabase= Room.databaseBuilder(context,UserDatabase.class,"furious_ladle_db").build();

    }


    @Override
    protected Boolean doInBackground(UserEntity... entities){
        userDatabase.getUserDao().insert(entities);
        return true;

    }



    @Override
    protected void onPostExecute(Boolean aBoolean){
        super.onPostExecute(aBoolean);
    }



}
