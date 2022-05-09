package sg.edu.rp.c346.id20013541.demosimpleclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    //Step 1: Declare the field variables
    TextView tvDisplay;
    Button btnDisplay;
    EditText etInput;
    ToggleButton tbtn;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //step 2: Link the field variables to UI components in layout
        tvDisplay = findViewById(R.id.textViewDisplay);
        btnDisplay = findViewById(R.id.buttonDisplay);
        etInput = findViewById(R.id.editTextInput);
        tbtn = findViewById(R.id.toggleButtonEnabled);
        rgGender= findViewById(R.id.radioGroupGender);

        tbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Code for the action
                if (tbtn.isChecked()) {
                    etInput.setEnabled(true);
                    btnDisplay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Code for the action
                            String stringResponse = etInput.getText().toString();
                            Toast.makeText(MainActivity.this, "Messagesaved as draft",
                                    Toast.LENGTH_LONG).show();
                            int checkedRadioId = rgGender.getCheckedRadioButtonId();
                            String stringResponse2 = "";
                            if (checkedRadioId == R.id.radioButtonGenderMale) {
                                // Write the code when male selected
                                stringResponse2 += "He says" + stringResponse;

                            } else {
                                // Write the code when female selected
                                stringResponse2 += "She says" + stringResponse;

                            }
                            tvDisplay.setText(stringResponse2);
                        }


                    });
                }else{
                    etInput.setEnabled(false);
                }
            }
        });



    }

}