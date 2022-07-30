package com.myapplicationdev.android.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    Button btnView;
    ArrayList<Song> songs;
    ListView lv;
    ArrayAdapter<Song> aa;
    CustomAdapter caSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        lv = findViewById(R.id.lv);
        btnView = findViewById(R.id.btnView);

        songs = new ArrayList<Song>();
        aa = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, songs);


        DBHelper dbh = new DBHelper(this);

        songs= dbh.getAllSongs();
       //aa = new ArrayAdapter<Song>(this, android.R.layout.simple_list_item_1, songs);
        //lv.setAdapter(aa);
        caSong = new CustomAdapter(this, R.layout.row, songs);
        lv.setAdapter(caSong);

        aa.notifyDataSetChanged();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song song = songs.get(position);
                Intent i = new Intent(ViewActivity.this,
                        EditActivity.class);
                i.putExtra("song", song);
                startActivity(i);
            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ViewActivity.this);
                songs = dbh.getAllSongsByStars(5);

                aa.notifyDataSetChanged();
            }
        });

    }
protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(ViewActivity.this);
        songs.clear();
        songs.addAll(dbh.getAllSongs());
        aa.notifyDataSetChanged();
        dbh.close();
    }
}