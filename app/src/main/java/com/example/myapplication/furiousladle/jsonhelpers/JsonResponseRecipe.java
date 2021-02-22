package com.example.myapplication.furiousladle.jsonhelpers;

import java.util.List;
import java.util.Objects;

public class JsonResponseRecipe {
    private String uri;     // Edamam recipe link
    private String label;   // Recipe title
    private String image;   // Recipe image url
    private String source;  // Recipe owner name
    private String url;     // Recipe external link
    private List<String> ingredientLines;   // Recipe ingredients

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getIngredientLines() {
        return ingredientLines;
    }

    public void setIngredientLines(List<String> ingredientLines) {
        this.ingredientLines = ingredientLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonResponseRecipe that = (JsonResponseRecipe) o;
        return uri.equals(that.uri) &&
                label.equals(that.label) &&
                image.equals(that.image) &&
                source.equals(that.source) &&
                url.equals(that.url) &&
                ingredientLines.equals(that.ingredientLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uri, label, image, source, url, ingredientLines);
    }

    @Override
    public String toString() {
        return "JsonResponseRecipe{" +
                "uri='" + uri + '\'' +
                ", label='" + label + '\'' +
                ", image='" + image + '\'' +
                ", source='" + source + '\'' +
                ", url='" + url + '\'' +
                ", ingredientLines=" + ingredientLines +
                '}';
    }
}
