package sg.edu.rp.c346.id20013541.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Step 1: Declare the field variables

    EditText etName;
    EditText etNumber;
    EditText etPax;
    DatePicker dp;
    TimePicker tp;
    Button btnReset;
    Button btnConfirm;
    CheckBox cbSmoke;
    CheckBox cbNoSmoke;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextPersonName);
        etNumber = findViewById(R.id.etNumber);
        etPax = findViewById(R.id.etGrpSize);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnConfirm = findViewById(R.id.btnCfm);
        btnReset= findViewById(R.id.btnReset);
        cbSmoke = findViewById(R.id.chkboxSmoke);
        cbNoSmoke = findViewById(R.id.chkboxNon);
        tvDisplay = findViewById(R.id.tvDisplay);

        dp.updateDate(2020,5,1);
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);
        tp.setIs24HourView(true);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String output="";

                if (etName.equals("")||etPax.equals("")||etNumber.equals("") ){
                    Toast.makeText(MainActivity.this,"Please enter all fields"
                            , Toast.LENGTH_LONG).show();
                }

                if (cbSmoke.isChecked()){
                    output = String.format("Name:%s \nMobile Number:%s \nGroup Size:%s \nSeating placement:%s \nDate & Time: %d/%d/%d %d:%d",etName.getText(), etNumber.getText(), etPax.getText(),cbSmoke.getText(),dp.getDayOfMonth(),dp.getMonth()+1,dp.getYear(),tp.getCurrentHour(),tp.getCurrentMinute());
                } else{

                    output = String.format("Name:%s \nMobile Number:%s \nGroup Size:%s \nSeating placement:%s \nDate & Time: %d/%d/%d %d:%d",etName.getText(), etNumber.getText(), etPax.getText(),cbNoSmoke.getText(),dp.getDayOfMonth(),dp.getMonth()+1,dp.getYear(),tp.getCurrentHour(),tp.getCurrentMinute());
                }
                tvDisplay.setText(output);


            }

            });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etName.setText("");
                etNumber.setText("");
                etPax.setText("");
                dp.updateDate(2020,5,1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                tvDisplay.setText("");


            }

            });

        tp.setOnTimeChangedListener(new OnTimeChangedListener(){
            @Override
            public void onTimeChanged(TimePicker v,int hourOfDay,int minute){
                // Add you code here to limit the time to 8AM and 8PM
                if (hourOfDay <=  7 && minute <= 00){
                    v.setCurrentHour(8);
                    v.setCurrentMinute(00);
                } else if (hourOfDay >= 21 && minute >= 00){
                    v.setCurrentHour(20);
                    v.setCurrentMinute(00);
                }



            }
        });


    }
}