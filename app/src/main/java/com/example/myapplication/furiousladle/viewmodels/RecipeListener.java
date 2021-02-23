package com.example.myapplication.furiousladle.viewmodels;

import com.example.myapplication.furiousladle.models.Recipe;

import java.util.List;

public interface RecipeListener {
    void onSuccessResponse(List<Recipe> data);
    void onErrorResponse(String data);
}
