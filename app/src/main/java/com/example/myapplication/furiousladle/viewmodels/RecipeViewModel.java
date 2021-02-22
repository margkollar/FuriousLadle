package com.example.myapplication.furiousladle.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


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
        return String.format("%s?app_id=%s&app_key=%s&q=%s",
                baseAPIPath, appID, appKey, parameter);

    }
    
    void retrieveRecipe(RecipeListener callback, String parameter) {
        // Request a string response from the provided URL.
        // TODO: check null parameter
        String url = prepareRequest(parameter);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccessResponse(response);
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
