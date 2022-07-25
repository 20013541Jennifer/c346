package com.myapplicationdev.android.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {

    Button btnUpdate, btnDelete, btnCancel;
    EditText etId,etTitle, etSingers, etYear;
    Song song;

    RadioGroup rgStars;

    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    RadioButton radio4;
    RadioButton radio5;

    ArrayList<Song> songs;
    ArrayAdapter<Song> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etId = findViewById(R.id.etId);
        etTitle = findViewById(R.id.etTitle);
        etSingers = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);

        radio1 = findViewById(R.id.rBtn1);
        radio2 = findViewById(R.id.rBtn2);
        radio3 = findViewById(R.id.rBtn3);
        radio4 = findViewById(R.id.rBtn4);
        radio5 = findViewById(R.id.rBtn5);

        rgStars = findViewById(R.id.rgStars);

        btnCancel = findViewById(R.id.btnCancel);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        Intent i = getIntent();
        song = (Song) i.getSerializableExtra("song");
        etId.setText(String.valueOf(song.getId()));
        etTitle.setText(song.getTitle());
        etSingers.setText(song.getSingers());
        etYear.setText(String.valueOf(song.getYear()));
        int stars = song.getStars();
        if(stars == 1){
            radio1.setChecked(true);
        }
        if(stars == 2){
            radio2.setChecked(true);
        }
        else if(stars == 3){
            radio3.setChecked(true);
        }
        else if(stars == 4){
            radio4.setChecked(true);
        } else{
            radio5.setChecked(true);
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                song.setTitle(etTitle.getText().toString());
                song.setSingers(etSingers.getText().toString());
                song.setYear(Integer.parseInt(etYear.getText().toString()));
                song.setStars(getStars());
                dbh.updateSong(song);
                dbh.close();

                Intent i = new Intent(EditActivity.this,
                        ViewActivity.class);
                startActivity(i);
                /*setResult(RESULT_OK);
                finish();*/
            }
            });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteSong(song.getId());

                Intent i = new Intent(EditActivity.this,
                        ViewActivity.class);
                startActivity(i);

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EditActivity.this,
                        ViewActivity.class);
                startActivity(i);
             /*   setResult(RESULT_CANCELED);
                finish();*/
            }});
    }

    private int getStars(){
        int stars = 1;
        if (rgStars.getCheckedRadioButtonId() == R.id.rBtn1){
            stars = 1;
        } else if (rgStars.getCheckedRadioButtonId() == R.id.rBtn2){
            stars = 2;
        } else if (rgStars.getCheckedRadioButtonId() == R.id.rBtn3){
            stars = 3;
        } else if (rgStars.getCheckedRadioButtonId() == R.id.rBtn4){
            stars = 4;
        } else if (rgStars.getCheckedRadioButtonId() == R.id.rBtn5){
            stars = 5;
        }
        return stars;
    }


}
