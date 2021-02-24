package com.example.myapplication.furiousladle.jsonhelpers;

import java.util.List;
import java.util.Objects;

public class JsonResponseHit {


    private JsonResponseRecipe recipe;

    public JsonResponseRecipe getRecipe() {
        return recipe;
    }

    public void setRecipe(JsonResponseRecipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonResponseHit that = (JsonResponseHit) o;
        return Objects.equals(recipe, that.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipe);
    }
}
