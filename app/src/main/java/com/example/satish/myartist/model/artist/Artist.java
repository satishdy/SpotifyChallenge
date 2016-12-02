package com.example.satish.myartist.model.artist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by satish on 12/1/16.
 */

public class Artist {
    @SerializedName("artists")
    @Expose
    private Artists artists;


    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }
}


