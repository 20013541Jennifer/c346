package sg.edu.rp.c346.id20013541.mymodules;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ModuleDetailActivity extends AppCompatActivity {

    TextView tvCode;
    TextView tvName;
    TextView tvYear;
    TextView tvSem;
    TextView tvCredit;
    TextView tvVenue;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);

        tvCode = findViewById(R.id.tvModuleCode);
        tvName = findViewById(R.id.tvModuleName);
        tvYear = findViewById(R.id.tvYear);
        tvSem = findViewById(R.id.tvSem);
        tvCredit = findViewById(R.id.tvCredit);
        tvVenue = findViewById(R.id.tvVenue);
        back = findViewById(R.id.btnBack);

        tvYear.setText("Academic Year: 2022");
        tvSem.setText("Semester: 1");

        Intent intentReceived = getIntent();
        int moduleSelected = intentReceived.getIntExtra("Module",0);

        if (moduleSelected == 346){
            //tvAnswer.setText(questionsSelected + " answer is: Queue");
            tvCode.setText("Module Code: C" + moduleSelected );
            tvName.setText("Module Name: Android Programming");
            tvCredit.setText("Module Credit: 4");
            tvVenue.setText("Venue: E62E");
        } else if ( moduleSelected == 300) {
            tvCode.setText("Module Code: C" + moduleSelected );
            tvName.setText("Module Name: FYP");
            tvCredit.setText("Module Credit: 4");
            tvVenue.setText("Venue: RPIC");
        } else if (moduleSelected == 373){
            tvCode.setText("Module Code: C" + moduleSelected );
            tvName.setText("Module Name: Distributed Ledger Technology Solutioning");
            tvCredit.setText("Module Credit: 4");
            tvVenue.setText("Venue: W54R");
        } else if ( moduleSelected == 1){
            tvCode.setText("Module Code: B" + moduleSelected );
            tvName.setText("Module Name: Stay Current, Share Perspectives");
            tvCredit.setText("Module Credit: 0");
            tvVenue.setText("Venue: E44R");
        } else {
            tvCode.setText("Module Code: E" + moduleSelected );
            tvName.setText("Module Name: Discovering Robotics");
            tvCredit.setText("Module Credit: 0");
            tvVenue.setText("Venue: ARCH LAB");
        }

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(ModuleDetailActivity.this, MainActivity.class);  //Create an Intent object
                intent.putExtra("Button",1);  //Pass data: name is “Question”; value is 2
                startActivity(intent);  //Launch the AnswerActivity
            }
        }
        );

    }
}