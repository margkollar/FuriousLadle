package com.example.myapplication.furiousladle.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;

public class UserEntityAsyncTask extends AsyncTask<UserEntity, UserEntity, Boolean> {
    UserDatabase dataBase;

    public UserEntityAsyncTask(Context context, @NonNull String dbName) {
        this.dataBase = Room.databaseBuilder(context, UserDatabase.class, "fl_db").build();
    }

    @Override
    protected Boolean doInBackground(UserEntity... userEntities) {
        dataBase.userDao().insert(userEntities);
        return false;
    }
}
