package com.example.e134292.downtimeCapture;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class studyActivity extends ActionBarActivity {

    private String[] arrTemp;

    private String studyTitle;
    private int numofReasons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        Bundle extras = getIntent().getExtras();
        studyTitle = extras.getString("STUDY_TITLE");
        numofReasons = extras.getInt("NUM_OF_REASONS");
        arrTemp = new String[numofReasons];
        arrTemp = extras.getStringArray("REASONS");

        //final TextView changeText = (TextView) findViewById(R.id.testTV);
        //changeText.setText(reason1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_study, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
