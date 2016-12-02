package com.example.satish.myartist.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.satish.myartist.R;
import com.example.satish.myartist.model.track.Track;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by satish on 12.01.2016.
 * Track adapter to render tracks data.
 */
public class TrackAdapter extends BaseAdapter {

    private static String TAG = "TrackAdapter";
    private List<Track> mTracks;
    private Context mContext;

    public TrackAdapter(Context context, List<Track> tracks) {
        super();
        this.mContext = context;
        this.mTracks = tracks;
    }

    @Override
    public int getCount() {
        return mTracks.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.track_list_item, parent, false);
        TextView txtAlbum = (TextView) v.findViewById(R.id.album);
        TextView txtTrack = (TextView) v.findViewById(R.id.track);
        ImageView thumbnail = (ImageView) v.findViewById((R.id.thumbnail));

        Track track = mTracks.get(position);
        txtAlbum.setText(track.getAlbum().getName());
        txtTrack.setText(track.getName());

        Picasso.with(mContext).load(track.getAlbum().getImages().get(0).getUrl())
                .error(R.drawable.track_default)
                .resize(200, 200)
                .into(thumbnail);

        Log.d(TAG, track.getAlbum().getName() + "-" + track.getName());
        return v;
    }
}
