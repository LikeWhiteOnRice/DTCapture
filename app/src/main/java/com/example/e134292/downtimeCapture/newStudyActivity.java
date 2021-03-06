package com.example.e134292.downtimeCapture;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class newStudyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_study);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_study, menu);
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

    public void gotoReasons (View view) {
        Intent intent = new Intent(this, reasonsActivity.class);

        EditText studyTitleET = (EditText) findViewById(R.id.studyTitle);
        String studyTitleST = studyTitleET.getText().toString();

        EditText numofReasonsET = (EditText) findViewById(R.id.numberOfReasons);
        int numofReasonsST = Integer.parseInt(numofReasonsET.getText().toString());

        Bundle extras = new Bundle();
        extras.putString("STUDY_TITLE", studyTitleST);
        extras.putInt("NUM_OF_REASONS", numofReasonsST);

        intent.putExtras(extras);
        startActivity(intent);
    }
}
