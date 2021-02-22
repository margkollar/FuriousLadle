package com.example.myapplication.furiousladle.jsonhelpers;

import java.util.List;
import java.util.Objects;

public class JsonResponseHit {
    private List<JsonResponseRecipe> Recipe;

    public List<JsonResponseRecipe> getRecipe() {
        return Recipe;
    }

    public void setRecipe(List<JsonResponseRecipe> recipe) {
        Recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonResponseHit that = (JsonResponseHit) o;
        return Recipe.equals(that.Recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Recipe);
    }

    @Override
    public String toString() {
        return "JsonResponseHit{" +
                "Recipe=" + Recipe +
                '}';
    }
}
