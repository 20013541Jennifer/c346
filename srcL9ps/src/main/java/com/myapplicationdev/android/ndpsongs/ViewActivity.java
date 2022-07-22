package com.myapplicationdev.android.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    ArrayList<Song> songs;
    ListView lv;
    ArrayAdapter<Song> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        lv = findViewById(R.id.lv);

        DBHelper dbh = new DBHelper(this);

        songs= dbh.getAllSongs();
       songs = dbh.getAllSongsByStars(5);
       ArrayAdapter<Song> adapter = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, songs);
        lv.setAdapter(adapter);

       // aa.notifyDataSetChanged();

    }
}