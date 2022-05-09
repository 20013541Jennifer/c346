package sg.edu.rp.c346.id20013541.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    //Step 1: Declare the field variables
    TextView tvDisplay;
    TextView tvDisplay2;
    TextView tvDisplayErrorAmt;
    TextView tvDisplayErrorDisc;
    TextView tvDisplayErrorPax;
    EditText etInputAmt;
    EditText etInputPax;
    EditText etInputDisc;
    ToggleButton tbtnSVS;
    ToggleButton tbtnGST;
    ToggleButton tbtnSplit;
    ToggleButton tbtnReset;
    RadioGroup rgPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //step 2: Link the field variables to UI components in layout
        tvDisplay = findViewById(R.id.textViewDisplay);
        tvDisplay2 = findViewById(R.id.textViewDisplay2);
        tvDisplayErrorAmt = findViewById(R.id.textViewErrorAmt);
        tvDisplayErrorPax = findViewById(R.id.textViewErrorPax);
        tvDisplayErrorDisc = findViewById(R.id.textViewErrorDisc);
        etInputAmt = findViewById(R.id.editTextAmt);
        etInputPax = findViewById(R.id.editTextPax);
        etInputDisc = findViewById(R.id.editTextDiscount);
        tbtnSVS = findViewById(R.id.toggleButtonSVS);
        tbtnGST = findViewById(R.id.toggleButtonGST);
        tbtnSplit = findViewById(R.id.toggleButtonSplit);
        tbtnReset = findViewById(R.id.toggleButtonReset);
        rgPayment= findViewById(R.id.radioGrpPayment);


        tbtnSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                double total_cost =0.0;
                double amt=0.0;
                if (tbtnSVS.isChecked() && tbtnGST.isChecked()) {
                    amt += Double.parseDouble(etInputAmt.getText().toString());
                    total_cost += (1+(0.10 + 0.07)) * amt;
                } else if (tbtnSVS.isChecked() && !tbtnGST.isChecked()) {
                    amt = Double.parseDouble(etInputAmt.getText().toString());
                    total_cost = (1+0.10) * amt;
                } else if (!tbtnSVS.isChecked() && tbtnGST.isChecked()){
                    amt = Double.parseDouble(etInputAmt.getText().toString());
                    total_cost = (1+0.07) * amt;
                } else {
                    amt = Double.parseDouble(etInputAmt.getText().toString());
                    total_cost =  amt;
                }

                if (etInputDisc.getText().toString().length()!=0){
                    total_cost *= (1 - Double.parseDouble(etInputDisc.getText().toString())/100);
                }

                tvDisplay.setText(String.format("Total Bill:$%.2f", total_cost));
                int pax = Integer.parseInt(etInputPax.getText().toString());
                if (pax > 0) {
                    int checkedRadioId = rgPayment.getCheckedRadioButtonId();
                    if (checkedRadioId == R.id.radioButtonCash){
                        tvDisplay2.setText(String.format("Each Pays: $%.2f in cash", total_cost / pax));
                    } else{
                        tvDisplay2.setText(String.format("Each Pays: $%.2f via PayNow 91234567", total_cost / pax));
                    }
                }

                if (etInputAmt.getText().toString().trim().length()==0){
                    tvDisplay.setText("");
                    tvDisplayErrorAmt.setText("Please enter an amount");
                } else if (Double.parseDouble(etInputAmt.getText().toString())<0){
                    tvDisplay.setText("");
                    tvDisplayErrorAmt.setText("Please enter an amount > 0");
                }

                if (Integer.parseInt(etInputPax.getText().toString())<0){
                    tvDisplay.setText("");
                    tvDisplayErrorPax.setText("Please enter a number > 0");
                }

                if (etInputDisc.getText().toString().trim().length()==0){
                    tvDisplay.setText("");
                    tvDisplayErrorDisc.setText("Please enter a number");
                } else if (Integer.parseInt(etInputDisc.getText().toString())<0){
                    tvDisplay.setText("");
                    tvDisplayErrorDisc.setText("Please enter a number > 0");
                }


            }
        });

        tbtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInputAmt.setText("");
                etInputPax.setText("");
                tbtnSVS.setChecked(false);
                tbtnGST.setChecked(false);
                etInputDisc.setText("");
                tvDisplay2.setText("");
                tvDisplay.setText("");
            }
        });




    }

}