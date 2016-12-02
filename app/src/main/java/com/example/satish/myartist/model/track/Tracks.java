package com.example.satish.myartist.model.track;

import com.example.satish.myartist.model.artist.Artists;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by satish on 12/1/16.
 */

public class Tracks {
    @SerializedName("tracks")
    @Expose
    private List<Track> tracks;

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Artists artists) {
        this.tracks = tracks;
    }
}


