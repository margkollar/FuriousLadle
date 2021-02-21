package com.example.myapplication.furiousladle;

import java.util.Objects;

public class RecipeModel {
    private String recipe;
    private String descr;
    private String url;

    public RecipeModel(String recipe, String descr, String url) {
        this.recipe = recipe;
        this.descr = descr;
        this.url = url;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRecipe() {
        return recipe;
    }

    public String getDescr() {
        return descr;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "RecipeModel{" +
                "recipe='" + recipe + '\'' +
                ", descr='" + descr + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeModel that = (RecipeModel) o;
        return Objects.equals(recipe, that.recipe) &&
                Objects.equals(descr, that.descr) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipe, descr, url);
    }
}
