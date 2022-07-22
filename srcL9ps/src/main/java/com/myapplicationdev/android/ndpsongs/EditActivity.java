package com.myapplicationdev.android.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class EditActivity extends AppCompatActivity {

    Button btnUpdate, btnDelete, btnCancel;
    EditText etId,etTitle, etSingers, etYear;

    RadioButton radio1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent i = getIntent();
        song = (Song) i.getSerializableExtra("song");
        etId.setText(String.valueOf(song.getId()));
        etTitle.setText(song.getTitle());
        etSingers.setText(song.getSingers());
        etYear.setText(song.getYearReleased());
        int stars = song.getStars();
        if(stars == 1){
            radio1.setChecked(true);
        }
        if(stars == 2){
            radio1.setChecked(true);
        }
        else if(stars == 3){
            radio1.setChecked(true);
        }
        else if(stars == 4){
            radio1.setChecked(true);
        } else{
            radio1.setChecked(true);
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                song.setTitle(etTitle.getText().toString()),
                        song.setSingers(etSingers.getText().toString()),
                        song.setYear(etYear.getText().toString()),
                        song.setStar(getStars()),
                        DBHelper dbh = newDBHelper(EditActivity.this);
                dbh.updateNote(song);
                setResult(RESULT_OK);
                finish();
            }});

        btnCancel.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }});
    }

    protected void onResume() {
        DBHelper dbh = newDBHelper(MainActivity.this);
        songs.clear();
        songs.addAll(dbh.getAllSongs());
        aa.notifyDataSetChanged();
        dbh.close();
    }
}