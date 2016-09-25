package com.example.alexsteen.hackgt16;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;

public class ExerciseList extends AppCompatActivity {
    private LinkedList<exerciseEntry> list;
    private String defaultNew = "";
    private String eHeader = "";
    private ListView exerView;

    private SharedPreferences.Editor editCurrentUser;
    private SharedPreferences currentUser;

    private FitnessDB fitDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);
        list = new LinkedList<>();
        exerView = (ListView) findViewById(R.id.exerciseLV);
        currentUser = getSharedPreferences("CurrentUser", MODE_PRIVATE);
        editCurrentUser = currentUser.edit();
        editCurrentUser.apply();
        String username = currentUser.getString("username", null);
        fitDB = new FitnessDB(this, username);

        String bundle = getIntent().getStringExtra("bundleID");

        if (bundle != null) {
            eHeader = bundle;
        }
        TextView head = (TextView) findViewById(R.id.eHeader);
        head.setText(eHeader);
    }



    public void addEntry(View view) {
        EditText newEntry = (EditText) findViewById(R.id.newEntry);
        exerciseEntry entry = new exerciseEntry(newEntry.getText().toString());
        if (newEntry.getText().toString().matches("")) {
            return;
        }
        list.add(0, entry);

        newEntry.setText(defaultNew);

        LinkedList<String> exerName = new LinkedList<>();

        for (exerciseEntry e : list) {
            exerName.add(e.getName());
        }
        exerView.setAdapter(new ArrayAdapter(this, R.layout.simple_list_item, exerName));
    }

//        exerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView parent, View view, int position, long id) {
//
//            }
//        });
}
