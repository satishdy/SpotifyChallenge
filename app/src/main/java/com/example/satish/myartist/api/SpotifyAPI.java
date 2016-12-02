package com.example.satish.myartist.api;

import com.example.satish.myartist.model.artist.Artist;
import com.example.satish.myartist.model.track.Track;
import com.example.satish.myartist.model.track.Tracks;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by satish on 12.01.2016.
 * Retrofit Spotify API calls.
 */
public interface SpotifyAPI {

    @GET("/v1/search")
    Call<Artist> getArtists(@Query("q") String artist, @Query("type") String type);

    @GET("/v1/artists/{id}/top-tracks")
    Call<Tracks> getTracks(@Path("id") String spotifyId, @Query("country") String country);
}
