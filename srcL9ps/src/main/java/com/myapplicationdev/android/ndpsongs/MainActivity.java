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
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnShow;
    EditText etTitle, etSinger, etYear;
    RadioGroup rgStars;
    ArrayList<Song> al;
    ArrayAdapter<Song> aa;
    //RadioButton btn1, btn2, btn3, btn4, btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShow);
        etTitle = findViewById(R.id.etTitle);
        etSinger = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);
        rgStars = findViewById(R.id.rgStars);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String singers = etSinger.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertSong(title,singers,year,getStars());

                if (inserted_id != -1){
                    al.clear();
                    al.addAll(dbh.getAllSongs());
                    aa.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ViewActivity.class);
                i.putExtra("data",al);
                startActivity(i);
            }
        });

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