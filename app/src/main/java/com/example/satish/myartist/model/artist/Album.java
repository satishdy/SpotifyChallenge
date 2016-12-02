package com.example.satish.myartist.model.artist;

import java.util.List;

/**
 * Created by satish on 12/1/16.
 */

public class Album {

    private List<Image> images;
    private String name;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
