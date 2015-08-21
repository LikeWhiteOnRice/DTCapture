package com.example.e134292.downtimeCapture;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class tempActivity extends Activity {
    private ListView myList;
    private MyAdapter myAdapter;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Bundle extras = getIntent().getExtras();
        String studyTitle = extras.getString("STUDY_TITLE");
        int numofReasons = extras.getInt("NUM_OF_REASONS");

        final TextView changeStudyTitle = (TextView) findViewById(R.id.studyTitleTV);
        //changeStudyTitle.setText(studyTitle);

        if (studyTitle.isEmpty()) {
            studyTitle = "New Study";
        }

        changeStudyTitle.setText(studyTitle);

        myList = (ListView) findViewById(R.id.MyList);
        myList.setItemsCanFocus(true);
        myAdapter = new MyAdapter(numofReasons, studyTitle);
        myList.setAdapter(myAdapter);
    }

    public class MyAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        //public ArrayList myItems = new ArrayList();
        public ArrayList myItems = new ArrayList();
        //public ArrayList > ListItem < myItems = new ArrayList > ListItem < ();

        public MyAdapter(int numofReasons, String studyTitle) {
            mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            for (int i = 0; i < numofReasons; i++) {
                ListItem listItem = new ListItem();
                listItem.caption = "Downtime Reason " + (i + 1);
                myItems.add(listItem);
            }
            notifyDataSetChanged();
        }

        public int getCount() {
            return myItems.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.item, null);
                holder.caption = (EditText) convertView
                        .findViewById(R.id.ItemCaption);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            //Fill EditText with the value you have in data source
            //holder.caption.setText(myItems.get(position).caption);
            holder.caption.setHint(((ListItem) myItems.get(position)).caption);
            holder.caption.setId(position);

            //we need to update adapter once we finish with editing
            holder.caption.setOnFocusChangeListener(new OnFocusChangeListener() {
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus){
                        final int position = v.getId();
                        final EditText Caption = (EditText) v;
                        (((ListItem)myItems.get(position)).caption) = Caption.getText().toString();


                    }
                }
            });

            return convertView;
        }
    }

    class ViewHolder {
        EditText caption;
    }

    class ListItem {
        String caption;
    }
}