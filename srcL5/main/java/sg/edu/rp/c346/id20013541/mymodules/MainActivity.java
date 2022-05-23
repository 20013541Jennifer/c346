package sg.edu.rp.c346.id20013541.mymodules;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvC346;
    TextView tvC300;
    TextView tvC373;
    TextView tvB001;
    TextView tvE001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvC346 = findViewById(R.id.tvC346);
        tvC300 = findViewById(R.id.tvC300);
        tvC373 = findViewById(R.id.tvC373);
        tvB001 = findViewById(R.id.tvB001);
        tvE001 = findViewById(R.id.tvE001);

        tvC346.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this, ModuleDetailActivity.class);  //Create an Intent object
                intent.putExtra("Module",346);  //Pass data: name is “Question”; value is 2
                startActivity(intent);  //Launch the AnswerActivity
            }
        }
        );

        tvC300.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this, ModuleDetailActivity.class);  //Create an Intent object
                intent.putExtra("Module",300);  //Pass data: name is “Question”; value is 2
                startActivity(intent);  //Launch the AnswerActivity
            }
        }
        );

        tvC373.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this, ModuleDetailActivity.class);  //Create an Intent object
                intent.putExtra("Module",373);  //Pass data: name is “Question”; value is 2
                startActivity(intent);  //Launch the AnswerActivity
            }
        }
        );

        tvB001.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this, ModuleDetailActivity.class);  //Create an Intent object
                intent.putExtra("Module",1);  //Pass data: name is “Question”; value is 2
                startActivity(intent);  //Launch the AnswerActivity
            }
        }
        );

        tvE001.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this, ModuleDetailActivity.class);  //Create an Intent object
                intent.putExtra("Module",2);  //Pass data: name is “Question”; value is 2
                startActivity(intent);  //Launch the AnswerActivity
            }
        }
        );

    }
}