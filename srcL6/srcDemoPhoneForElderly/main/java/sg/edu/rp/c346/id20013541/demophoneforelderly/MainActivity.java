package sg.edu.rp.c346.id20013541.demophoneforelderly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSon;
    Button btnDaughter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDaughter = findViewById(R.id.buttonCallDaughter);
        btnSon = findViewById(R.id.buttonCallSon);

        btnSon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+92240336));  //Create an Intent object
                intentCall.putExtra("Module",346);
                startActivity(intentCall);  //Launch the AnswerActivity
            }
        }
        );
    }
}