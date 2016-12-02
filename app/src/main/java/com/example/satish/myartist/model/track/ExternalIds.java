
package com.example.satish.myartist.model.track;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExternalIds {

    @SerializedName("isrc")
    @Expose
    private String isrc;

    /**
     * 
     * @return
     *     The isrc
     */
    public String getIsrc() {
        return isrc;
    }

    /**
     * 
     * @param isrc
     *     The isrc
     */
    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

}
