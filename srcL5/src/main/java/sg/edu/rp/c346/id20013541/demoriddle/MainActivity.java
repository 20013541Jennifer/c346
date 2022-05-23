package sg.edu.rp.c346.id20013541.demoriddle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Event handling step 1
    TextView tvQ1;
    Button btnRevealQ1;
    TextView tvQ2;
    Button btnRevealQ2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Event handling Step 2
        tvQ1 = findViewById(R.id.textViewQ1);
        btnRevealQ1 = findViewById(R.id.buttonRevealQ1);
        tvQ2 = findViewById(R.id.textViewQ2);
        btnRevealQ2 = findViewById(R.id.buttonRevealQ2);

        //Event handling step 3
        btnRevealQ1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {

                /*Intent intent = new Intent( MainActivity.this, AnswerActivity1.class);
                intent.putExtra("Question","Q1");
                startActivity(intent);*/

                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);  //Create an Intent object
                intent.putExtra("Question",1);  //Pass data: name is “Question”; value is 2
                startActivity(intent);  //Launch the AnswerActivity


            }
                                       }


        );

        //Event handling step 3
        btnRevealQ2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {

               /* Intent intent = new Intent( MainActivity.this, AnswerActivity1.class);
                intent.putExtra("Question2","Q2");
                startActivity(intent);*/

                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);  //Create an Intent object
                intent.putExtra("Question",2);  //Pass data: name is “Question”; value is 2
                startActivity(intent);  //Launch the AnswerActivity


            }
        }

        );
    }
}