package com.example.myapplication.furiousladle.viewmodels;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.furiousladle.Search;
import com.example.myapplication.furiousladle.jsonhelpers.JsonResponse;
import com.example.myapplication.furiousladle.jsonhelpers.JsonResponseHit;
import com.example.myapplication.furiousladle.jsonhelpers.JsonResponseRecipe;
import com.example.myapplication.furiousladle.models.Recipe;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class RecipeViewModel extends AndroidViewModel {
    private final String appID = "eb3439ca";
    private final String appKey = "cc857c2c04f1702d19d6bc1fa6099c04";
    private final String baseAPIPath = "https://api.edamam.com/search";
    private RequestQueue queue;

//    @NonNull
//    private Request queue;

    public RecipeViewModel(@NonNull Application application) {
        super(application);
        queue = Volley.newRequestQueue(application);
    }

    public String prepareRequest(@NonNull String parameter){
        String TheQuery = String.format("%s?app_id=%s&app_key=%s&q=%s",
                baseAPIPath, appID, appKey, parameter);
        Log.d("THE TERM",TheQuery);
        return TheQuery;

    }
    
    public void retrieveRecipe(RecipeListener callback, String parameter) {
        // Request a string response from the provided URL.
        // TODO: check null parameter
        String url = prepareRequest(parameter);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        List<Recipe> recipesModel = new ArrayList<>();
                        List<JsonResponseHit> jHits = new ArrayList<>();
                        List<JsonResponseRecipe> recipes = new ArrayList<>();

                        JsonResponse jResp = new Gson().fromJson(response, JsonResponse.class);
//                       Jrecipes list
                        jHits = jResp.getHit();
                        Log.d("THE HIT", jHits.toString());

                        for(JsonResponseHit item : jHits){
                            JsonResponseRecipe recipe = item.getRecipe();
                                Recipe theRecipe = new Recipe();
                                theRecipe.setTitle(recipe.getLabel());
                                theRecipe.setOwner(recipe.getSource());
                                theRecipe.setImageURL(recipe.getImage());
                                theRecipe.setExternalURL(recipe.getUrl());
                                theRecipe.setInternalURL(recipe.getUri());
                                theRecipe.setIngredients(recipe.getIngredientLines());

                                recipesModel.add(theRecipe);
                                Log.d("JSON", theRecipe.toString());
                                Toast.makeText(getApplication(),"Response",Toast.LENGTH_LONG).show();
                        }

//                        for(JsonResponseHit jhit : hits){
//                            for(JsonResponseRecipe jre. : jhit){
                        for(int i=0;i<10;i++){

                        };
                        callback.onSuccessResponse(recipesModel);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onErrorResponse("Could not perform the request");
                    }
                });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

}
