package sg.edu.rp.c346.id20013541.demoriddle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    TextView tvAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        tvAnswer = findViewById(R.id.textView2);

        Intent intentReceived = getIntent();
        int questionsSelected = intentReceived.getIntExtra("Question",0);

        if (questionsSelected == 1){
            tvAnswer.setText(questionsSelected + " answer is: Queue");
        } else {
            tvAnswer.setText(questionsSelected + " answer is: Gone");

        }

    }
}