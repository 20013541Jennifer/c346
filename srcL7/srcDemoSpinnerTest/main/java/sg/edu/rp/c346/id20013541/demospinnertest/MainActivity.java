package sg.edu.rp.c346.id20013541.demospinnertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Spinner spnYesNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        spnYesNo = findViewById(R.id.spinner);

        spnYesNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                String selected = spnYesNo.getSelectedItem().toString();
                switch (position){
                    case 0:
                        tv.setText("Spinner Item, " + selected+" Selected");
                        break;
                    case 1:
                        String selected1 = spnYesNo.getSelectedItem().toString();
                        tv.setText("Spinner Item, " + selected+ " Selected");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });
    }

}