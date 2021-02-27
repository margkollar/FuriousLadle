package com.example.myapplication.furiousladle.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

public class InsertUserAsyncTask extends AsyncTask<UserEntity,UserEntity,Boolean>
{
    private InsertCallbackListener callback;
    UserDatabase userDatabase;
    public InsertUserAsyncTask(Context context, InsertCallbackListener callback) {
        this.callback = callback;
        userDatabase= Room.databaseBuilder(context,UserDatabase.class,"furious_ladle_db").build();
    }

    @Override
    protected Boolean doInBackground(UserEntity... userEntities) {
       userDatabase.getUserDao().insert(userEntities);
       return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        callback.onSuccessResult();
    }
}
