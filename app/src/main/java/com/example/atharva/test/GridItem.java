package com.example.atharva.test;

/**
 * Created by atharva on 19/2/18.
 */

public class GridItem {
    public String text;
    public String imageUrl;

    public GridItem() {
    }

    public GridItem(String text,String imageUrl) {
        this.text = text;
        this.imageUrl = imageUrl;
    }

    public String getTexts() {
        return text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTexts(String text) {
        this.text = text;
    }
}
