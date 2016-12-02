package com.example.satish.myartist.model.artist;

/**
 * Created by satish on 12/1/16.
 */

public class Track {
    private Album album;
    private String name;
    private String uri;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
