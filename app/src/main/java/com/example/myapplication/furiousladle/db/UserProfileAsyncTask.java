package com.example.myapplication.furiousladle.db;

import android.os.AsyncTask;

public class UserProfileAsyncTask extends AsyncTask<UserEntity,UserEntity,UserEntity> {
    private UserProfileCallback listener;
    private UserDatabase database;

    public UserProfileAsyncTask(UserProfileCallback listener, UserDatabase database) {
        this.listener = listener;
        this.database = database;
    }

    @Override
    protected UserEntity doInBackground(UserEntity... userEntities) {
        return database.getUserDao().getFirstEntity();
    }

    @Override
    protected void onPostExecute(UserEntity userEntity) {
        super.onPostExecute(userEntity);
    }
}
