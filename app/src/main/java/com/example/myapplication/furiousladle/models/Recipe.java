package com.example.myapplication.furiousladle.models;

import java.util.ArrayList;
import java.util.Objects;

public class Recipe {
    private String title;
    private String owner;
    private ArrayList<String> ingredients;
    private String internalURL;
    private String externalURL;
    private String imageURL;

    public Recipe(){}

    public Recipe(String title, String owner, ArrayList<String> ingredients, String internalURL, String externalURL, String imageURL) {
        this.title = title;
        this.owner = owner;
        this.ingredients = ingredients;
        this.internalURL = internalURL;
        this.externalURL = externalURL;
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInternalURL() {
        return internalURL;
    }

    public void setInternalURL(String internalURL) {
        this.internalURL = internalURL;
    }

    public String getExternalURL() {
        return externalURL;
    }

    public void setExternalURL(String externalURL) {
        this.externalURL = externalURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return title.equals(recipe.title) &&
                owner.equals(recipe.owner) &&
                ingredients.equals(recipe.ingredients) &&
                internalURL.equals(recipe.internalURL) &&
                externalURL.equals(recipe.externalURL) &&
                imageURL.equals(recipe.imageURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, owner, ingredients, internalURL, externalURL, imageURL);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "title='" + title + '\'' +
                ", owner='" + owner + '\'' +
                ", ingredients=" + ingredients +
                ", internalURL='" + internalURL + '\'' +
                ", externalURL='" + externalURL + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
