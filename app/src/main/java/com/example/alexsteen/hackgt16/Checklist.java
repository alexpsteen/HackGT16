package com.example.alexsteen.hackgt16;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.LinkedList;

public class Checklist extends AppCompatActivity {
    private LinkedList<Elist> exercises;
    private ListView exerView;
    private String defaultNew = "";

    private SharedPreferences.Editor editCurrentUser;
    private SharedPreferences currentUser;
    private LinkedList<String> exerName;
    private String username;

    private FitnessDB fitDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);
        exercises = new LinkedList<>();
        exerView = (ListView) findViewById(R.id.listView);

        //EditText newEntry = (EditText) findViewById(R.id.newEntry);
        currentUser = getSharedPreferences("CurrentUser", MODE_PRIVATE);
        editCurrentUser = currentUser.edit();
        editCurrentUser.apply();
        username = currentUser.getString("username", null);
        exerName = new LinkedList<>();

        fitDB = new FitnessDB(this, username);

//        exercises = fitDB.getELists();
        for (Elist e: exercises) {
            exerName.add(e.toString());
        }
        exerView.setAdapter(new ArrayAdapter(this, R.layout.simple_list_item, exerName));
    }

    public void addEntry(View view) {
        EditText newEntry = (EditText) findViewById(R.id.newEntry);
        Elist elist = new Elist(newEntry.getText().toString());
        if (newEntry.getText().toString().matches("")) {
            return;
        }
        exercises.add(0, elist);

        newEntry.setText(defaultNew);
        LinkedList<String> exerName = new LinkedList<>();
        for (Elist e: exercises) {
            exerName.add(e.toString());
        }
        exerView.setAdapter(new ArrayAdapter(this, R.layout.simple_list_item, exerName));

        exerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Intent i = new Intent(Checklist.this, ExerciseList.class);
                Bundle bundle = new Bundle();

                bundle.putString("bundleID", exercises.get(position).toString());
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}
