package com.example.myapplication.furiousladle.models;

import java.util.ArrayList;
import java.util.Objects;

public class Recipe {
    private String title;
    private String description;
    private ArrayList<String> ingredients;
    private String tags;
    private String contentURL;
    private String imageURL;

    public Recipe(){}

    public Recipe(String title, String description, ArrayList<String> ingredients, String tags,
                  String contentURL, String imageURL) {
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.tags = tags;
        this.contentURL = contentURL;
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getContentURL() {
        return contentURL;
    }

    public void setContentURL(String contentURL) {
        this.contentURL = contentURL;
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
                description.equals(recipe.description) &&
                ingredients.equals(recipe.ingredients) &&
                Objects.equals(imageURL, recipe.imageURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, ingredients, imageURL);
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients;
    }


}
