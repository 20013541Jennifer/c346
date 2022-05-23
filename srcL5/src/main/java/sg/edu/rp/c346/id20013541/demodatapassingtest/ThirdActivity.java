package sg.edu.rp.c346.id20013541.demodatapassingtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    //Step 1
    TextView tvAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //Event handling Step 2
       tvAnswer = findViewById(R.id.textView2);

        //Step 2
        Intent intentReceived = getIntent();
        char value = intentReceived.getCharExtra("char",'a');
        tvAnswer.setText("Character value received is: " + value);
    }
}