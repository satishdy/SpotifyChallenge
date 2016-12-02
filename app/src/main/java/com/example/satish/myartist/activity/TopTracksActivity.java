package com.example.satish.myartist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.satish.myartist.R;
import com.example.satish.myartist.adapter.ArtistAdapter;
import com.example.satish.myartist.adapter.TrackAdapter;
import com.example.satish.myartist.api.SpotifyAPI;
import com.example.satish.myartist.model.artist.Item;
import com.example.satish.myartist.model.track.Track;
import com.example.satish.myartist.model.track.Tracks;
import com.example.satish.myartist.utility.Constants;
import com.example.satish.myartist.utility.Utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by satish on 12.01.2016.
 */
public class TopTracksActivity extends AppCompatActivity {

    private Retrofit mRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_tracks);

        mRetrofit = Utils.provideRetrofit(getApplication(), this);

        String artist = getIntent().getStringExtra(Constants.EXTRA_ARTIST);
        TextView textArtist = (TextView) findViewById(R.id.textArtist);
        textArtist.setText(artist);

        String spotifyId = getIntent().getStringExtra(Constants.EXTRA_SPOTIFY_ID);
        loadTop10Tracks(spotifyId);
    }

    public void loadTop10Tracks(String spotifyId) {
        final ListView trackListView = (ListView) findViewById(R.id.trackList);

        SpotifyAPI api = mRetrofit.create(SpotifyAPI.class);

        Call<Tracks> call = api.getTracks(spotifyId, "US");

        call.enqueue(new Callback<Tracks>() {
            @Override
            public void onResponse(Call<Tracks> call, Response<Tracks> response) {

                Tracks tracks = response.body();

                if (tracks.getTracks().size() == 0) {
                    showError();
                }

                TrackAdapter trackAdapter = new TrackAdapter(TopTracksActivity.this, tracks.getTracks());

                try {
                    trackListView.setAdapter(trackAdapter);
                } catch (Exception e) {
                    showError();
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Tracks> call, Throwable t) {
                showError();
            }
        });
    }

    public void closeActivity(View view) {
        finish();
    }

    private void showError() {
        Toast.makeText(TopTracksActivity.this, getString(R.string.error_tracks_not_found), Toast.LENGTH_SHORT).show();
    }
}
