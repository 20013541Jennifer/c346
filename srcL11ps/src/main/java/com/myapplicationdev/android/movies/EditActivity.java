package com.myapplicationdev.android.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    Button btnUpdate, btnDelete, btnCancel;
    EditText etId,etTitle, etGenre, etYear;

    Spinner spinner;
    ArrayAdapter<String> spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        etId = findViewById(R.id.etId);
        etTitle = findViewById(R.id.etTitle);
        etGenre = findViewById(R.id.etGenre);
        etYear = findViewById(R.id.etYear);
        spinner = (Spinner) this.findViewById(R.id.spn);

        btnCancel = findViewById(R.id.btnCancel);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        Intent i = getIntent();
        final Movie currentMovie = (Movie) i.getSerializableExtra("movie");

        etId.setText(String.valueOf(currentMovie.getId()));
        etTitle.setText(currentMovie.getTitle());
        etGenre.setText(currentMovie.getGenre());
        etYear.setText(currentMovie.getYear()+"");
        spinner.getSelectedItem();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                currentMovie.setTitle(etTitle.getText().toString().trim());
                currentMovie.setGenre(etGenre.getText().toString().trim());
                int year = 0;
                try {
                    year = Integer.valueOf(etYear.getText().toString().trim());
                } catch (Exception e){
                    Toast.makeText(EditActivity.this, "Invalid year", Toast.LENGTH_SHORT).show();
                    return;
                }
                currentMovie.setYear(year);

                currentMovie.setRating(spinner.getSelectedItem().toString());

                int result = dbh.updateMovie(currentMovie);
                if (result>0){
                    Toast.makeText(EditActivity.this, "Movie updated", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(EditActivity.this, "Update failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                int result = dbh.deleteMovie(currentMovie.getId());

                if (result>0){
                    Toast.makeText(EditActivity.this, "Movie deleted", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(EditActivity.this, "Delete failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}