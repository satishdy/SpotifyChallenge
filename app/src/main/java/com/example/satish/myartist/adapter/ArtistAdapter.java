package com.example.satish.myartist.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.satish.myartist.R;
import com.example.satish.myartist.model.artist.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by satish on 12.01.2016.
 * Artist adapter to render artists data.
 */
public class ArtistAdapter extends BaseAdapter {

    private static String TAG = "ArtistAdapter";
    private List<Item> mArtists;
    private Context mContext;

    public ArtistAdapter(Context context, List<Item> artists) {
        super();
        this.mContext = context;
        this.mArtists = artists;
    }

    @Override
    public int getCount() {
        return mArtists.size();
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
        View v = inflater.inflate(R.layout.artist_list_item, parent, false);
        TextView txtArtist = (TextView) v.findViewById(R.id.artist);
        ImageView thumbnail = (ImageView) v.findViewById((R.id.thumbnail));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(200, 200);
        thumbnail.setLayoutParams(layoutParams);

        Item artist = mArtists.get(position);
        txtArtist.setText(artist.getName());

        if (artist.getImages().size() > 0) {
            Picasso.with(mContext).load(artist.getImages().get(0).getUrl())
                    .error(R.drawable.artist_default)
                    .resize(200, 200)
                    .into(thumbnail);
        }

        Log.d(TAG, artist.getName());
        return v;
    }


}
