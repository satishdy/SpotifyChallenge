
package com.example.satish.myartist.model.track;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("tracks")
    @Expose
    private List<Track> tracks = new ArrayList<Track>();

    /**
     * 
     * @return
     *     The tracks
     */
    public List<Track> getTracks() {
        return tracks;
    }

    /**
     * 
     * @param tracks
     *     The tracks
     */
    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

}
