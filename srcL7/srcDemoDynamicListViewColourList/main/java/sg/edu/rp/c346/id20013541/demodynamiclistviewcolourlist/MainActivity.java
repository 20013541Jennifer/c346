package sg.edu.rp.c346.id20013541.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    Button btnAdd;
    Button btnDel;
    Button btnUpdate;
    ListView lvColour;
    EditText etIndexElement;

    ArrayList <String> alColours;
    ArrayAdapter<String > aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnDel = findViewById(R.id.buttonDelete);
        btnUpdate = findViewById(R.id.buttonUpdate);
        lvColour = findViewById(R.id.listViewColour);
        etIndexElement = findViewById(R.id.editTextIndex);

        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter <>(this, android.R.layout.simple_list_item_1, alColours);

        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String colourName = etElement.getText().toString();
                //alColours.add(colourName);
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos,colourName);
                aaColour.notifyDataSetChanged();
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = Integer.parseInt(etIndexElement.getText().toString());
                //alColours.add(colourName);
                alColours.remove(index);
                aaColour.notifyDataSetChanged();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String colourName = etElement.getText().toString();
                //alColours.add(colourName);
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.set(pos,colourName);
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selected = alColours.get(position).toString();
                Toast.makeText(MainActivity.this, selected, Toast.LENGTH_SHORT).show();
            }
        });


    }
}