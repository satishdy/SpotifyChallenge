
package com.example.satish.myartist.model.artist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("artists")
    @Expose
    private Artists artists;

    /**
     * 
     * @return
     *     The artists
     */
    public Artists getArtists() {
        return artists;
    }

    /**
     * 
     * @param artists
     *     The artists
     */
    public void setArtists(Artists artists) {
        this.artists = artists;
    }

}
