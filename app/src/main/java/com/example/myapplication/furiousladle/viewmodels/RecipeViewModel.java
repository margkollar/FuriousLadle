package com.example.myapplication.furiousladle.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class RecipeViewModel extends AndroidViewModel {
    private final String appID = "eb3439ca";
    private final String appKey = "cc857c2c04f1702d19d6bc1fa6099c04";
    private final String baseAPIPath = "https://api.edamam.com/search";

//    @NonNull
//    private Request queue;

    public RecipeViewModel(@NonNull Application application) {
        super(application);
    }
    public String prepareRequest(@NonNull String parameter){
        return String.format("%s?app_id=%s&app_key=%s&q=%s",
                baseAPIPath, appID, appKey, parameter);

    }

    void retrieveProgram(RecipeListener callback) {

    }
}
