package com.myapplicationdev.android.ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Song> songs;

    TextView tvTitle, tvSingers, tvStars, tvYears;

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects){
        super(context,resource,objects);

        parent_context = context;
        layout_id = resource;
        songs = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        tvTitle = rowView.findViewById(R.id.tvTitle);
        tvSingers = rowView.findViewById(R.id.tvSinger);
        tvStars = rowView.findViewById(R.id.tvStars);
        tvYears = rowView.findViewById(R.id.tvYearr);

        // Obtain the Android Version information based on the position
        Song currentSong = songs.get(position);

        // Set values to the TextView to display the corresponding information
        tvTitle.setText(currentSong.getTitle());
        tvSingers.setText((currentSong.getSingers()));
        String stars ="";
        for (int i=0; i<currentSong.getStars(); i++){
            stars+="*";
        }
        tvStars.setText(stars);
        tvYears.setText(currentSong.getYear()+"");

        return rowView;
    }

}
