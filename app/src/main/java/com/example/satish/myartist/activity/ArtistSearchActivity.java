package com.example.satish.myartist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.satish.myartist.R;
import com.example.satish.myartist.adapter.ArtistAdapter;
import com.example.satish.myartist.api.SpotifyAPI;
import com.example.satish.myartist.model.artist.Artist;
import com.example.satish.myartist.model.artist.Item;
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
public class ArtistSearchActivity extends AppCompatActivity {

    private Retrofit mRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_search);

        mRetrofit = Utils.provideRetrofit(getApplication(), this);
    }

    public void loadArtists(View view) {
        EditText txtArtist = (EditText) findViewById(R.id.searchText);
        String artist = txtArtist.getText().toString();
        final ListView artistListView = (ListView) findViewById(R.id.artistList);
        if (artist.length() == 0) {
            Toast.makeText(this, "Please enter the artist.", Toast.LENGTH_SHORT).show();
        } else {

            SpotifyAPI api = mRetrofit.create(SpotifyAPI.class);

            Call<Artist> call = api.getArtists(artist, "artist");

            call.enqueue(new Callback<Artist>() {
                @Override
                public void onResponse(Call<Artist> call, Response<Artist> response) {

                    Artist artists = response.body();

                    final List<Item> items = artists.getArtists().getItems();

                    if (items.size() == 0) {
                        showError();
                    }

                    ArtistAdapter artistAdapter = new ArtistAdapter(ArtistSearchActivity.this, items);

                    try {
                        artistListView.setAdapter(artistAdapter);
                        artistListView.setOnItemClickListener(new OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                                    long arg3) {
                                startTracksActivity(items.get(position).getId(), items.get(position).getName());
                            }
                        });
                    } catch (Exception e) {
                        showError();
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<Artist> call, Throwable t) {
                    showError();
                }
            });
        }
    }

    private void startTracksActivity(String spotifyId, String artist) {
        Intent intent = new Intent(this, TopTracksActivity.class);
        intent.putExtra(Constants.EXTRA_SPOTIFY_ID, spotifyId);
        intent.putExtra(Constants.EXTRA_ARTIST, artist);
        startActivity(intent);
    }

    private void showError() {
        Toast.makeText(ArtistSearchActivity.this, getString(R.string.error_artist_not_found), Toast.LENGTH_SHORT).show();
    }
}
