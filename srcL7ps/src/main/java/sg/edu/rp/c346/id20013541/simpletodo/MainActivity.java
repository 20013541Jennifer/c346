package sg.edu.rp.c346.id20013541.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTask;
    Button btnAdd;
    Button btnClear;
    Button btnDel;
    ListView lvTasks;
    Spinner spnItem;

    ArrayList<String> alTasks;
    ArrayAdapter<String > aaTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTask = findViewById(R.id.etTask);
        btnAdd = findViewById(R.id.btnAdd);
        btnClear = findViewById(R.id.btnClear);
        lvTasks = findViewById(R.id.lvTasks);
        btnDel = findViewById(R.id.btnDel);
        spnItem = findViewById(R.id.spinner);

        alTasks = new ArrayList<>();
        aaTask = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alTasks);

        lvTasks.setAdapter(aaTask);

        /*btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taskName = etTask.getText().toString();
                alTasks.add(taskName);
                etTask.setText("");
                //int pos = Integer.parseInt(etIndexElement.getText().toString());
                //alColours.add(pos,colourName);
                aaTask.notifyDataSetChanged();
            }
        });*/

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alTasks.clear();
                etTask.setText("");
                aaTask.notifyDataSetChanged();
            }
        });

        spnItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                String selected = spnItem.getSelectedItem().toString();
                switch (position){
                    case 0:
                        etTask.setHint("Type in a new task here");
                        btnDel.setEnabled(false);
                        btnAdd.setEnabled(true);
                        btnAdd.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String taskName = etTask.getText().toString();
                                alTasks.add(taskName);
                                etTask.setText("");
                                //int pos = Integer.parseInt(etIndexElement.getText().toString());
                                //alColours.add(pos,colourName);
                                aaTask.notifyDataSetChanged();
                            }
                        });
                        break;
                    case 1:
                        etTask.setHint("Type in the index of the task to be removed");
                        btnAdd.setEnabled(false);
                        btnDel.setEnabled(true);
                        btnDel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                int pos = Integer.parseInt(etTask.getText().toString());
                                //alColours.add(pos,colourName);

                                    if(alTasks.isEmpty()){
                                        Toast.makeText(MainActivity.this, "You don't have any task to remove", Toast.LENGTH_SHORT).show();
                                    } else if (alTasks.get(pos).isEmpty()){
                                        Toast.makeText(MainActivity.this, "Wrong Index number", Toast.LENGTH_SHORT).show();
                                    } else{
                                        alTasks.remove(pos);
                                    }


                                etTask.setText("");
                                aaTask.notifyDataSetChanged();
                            }
                        });
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });

    }
}