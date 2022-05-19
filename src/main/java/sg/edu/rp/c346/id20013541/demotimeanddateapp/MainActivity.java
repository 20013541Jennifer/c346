package sg.edu.rp.c346.id20013541.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //step 2: Link the field variables to UI components in layout
        tvDisplay = findViewById(R.id.textViewDisplay);
        dp = findViewById(R.id.datePicker);
        btnDisplayDate= findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tp = findViewById(R.id.timePicker);
        btnReset = findViewById(R.id.btnReset);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDisplay.setText("Time is " + tp.getCurrentHour() + ":" + tp.getCurrentMinute());
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDisplay.setText(String.format("Date is %d/%d/%d ", dp.getDayOfMonth(), dp.getMonth()+1, dp.getYear()) );

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tp.setCurrentHour(00);
                tp.setCurrentMinute(00);
                dp.updateDate(2020,00,01);
                tvDisplay.setText("");

            }
        });




    }



}