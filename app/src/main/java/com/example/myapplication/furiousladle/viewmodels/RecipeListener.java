package com.example.myapplication.furiousladle.viewmodels;

public interface RecipeListener {
    void onSuccessResponse(String data);
    void onErrorResponse(String data);
}
