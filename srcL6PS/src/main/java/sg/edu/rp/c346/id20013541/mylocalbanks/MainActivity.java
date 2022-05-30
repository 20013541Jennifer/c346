package sg.edu.rp.c346.id20013541.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvUOB;
    TextView tvOCBC;
    String wordClicked="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.tvDBS);
        registerForContextMenu(tvDBS);

        tvOCBC = findViewById(R.id.tvOCBC);
        registerForContextMenu(tvOCBC);

        tvUOB = findViewById(R.id.tvUOB);
        registerForContextMenu(tvUOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
        menu.add(0, 2, 2, "Toggle Favourite");



        if (v == tvDBS){
            wordClicked="dbs";
        } else if ( v == tvOCBC){
            wordClicked="ocbc";
        } else if ( v == tvUOB){
            wordClicked="uob";
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText(getResources().getString(R.string.dbs));
            tvOCBC.setText(getResources().getString(R.string.ocbc));
            tvUOB.setText(getResources().getString(R.string.uob));
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText(getResources().getString(R.string.dbsChi));
            tvOCBC.setText(getResources().getString(R.string.ocbcChi));
            tvUOB.setText(getResources().getString(R.string.uobChi));
            return true;
        } else {
            tvDBS.setText("Error translation");
            tvOCBC.setText("Error translation");
            tvUOB.setText("Error translation");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.dbsSite)));  //Create an Intent object
                intentCall.putExtra("Module", 346);
                startActivity(intentCall);  //Launch the AnswerActivity
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getResources().getString(R.string.dbsNum)));  //Create an Intent object
                intentCall.putExtra("Module", 346);
                startActivity(intentCall);  //Launch the AnswerActivity
                return true;  //menu item successfully handled
            } else if (item.getItemId() == 2) { //check if the selected menu item ID is 1
                tvDBS.setTextColor(0xffff0000);
                return true;  //menu item successfully handled
            }
        } else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.ocbcSite)));  //Create an Intent object
                intentCall.putExtra("Module", 346);
                startActivity(intentCall);  //Launch the AnswerActivity
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getResources().getString(R.string.ocbcNum)));  //Create an Intent object
                intentCall.putExtra("Module", 346);
                startActivity(intentCall);  //Launch the AnswerActivity
                return true;  //menu item successfully handled
            } else if (item.getItemId() == 2) { //check if the selected menu item ID is 1
                tvOCBC.setTextColor(0xffff0000);
                return true;  //menu item successfully handled
            }
        } else if (wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.uobSite)));  //Create an Intent object
                intentCall.putExtra("Module", 346);
                startActivity(intentCall);  //Launch the AnswerActivity
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getResources().getString(R.string.uobNum)));  //Create an Intent object
                intentCall.putExtra("Module", 346);
                startActivity(intentCall);  //Launch the AnswerActivity
                return true;  //menu item successfully handled
            } else if (item.getItemId() == 2) { //check if the selected menu item ID is 1
                tvUOB.setTextColor(0xffff0000);
                return true;  //menu item successfully handled
            }
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation

}
    }

