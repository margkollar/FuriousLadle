package com.example.myapplication.furiousladle.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import java.util.List;

public class UserGetEntityAsyncTask extends AsyncTask<UserEntity,UserEntity, List<UserEntity>> {
    UserDatabase userDatabase;
    UserEntityListener listener;

    public UserGetEntityAsyncTask(Context context,UserEntityListener listener){
        userDatabase= Room.databaseBuilder(context,UserDatabase.class,"furious_ladle_db").build();
        this.listener=listener;
    }


    @Override
    protected List<UserEntity> doInBackground(UserEntity... entities){
        return userDatabase.getUserDao().getEntity();
    }

    @Override
    protected void onPostExecute(List<UserEntity> results){
        super.onPostExecute(results);
        listener.onSuccessResult(results);
    }

}
