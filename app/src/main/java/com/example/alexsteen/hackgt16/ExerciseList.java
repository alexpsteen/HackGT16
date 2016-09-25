package com.example.alexsteen.hackgt16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.LinkedList;

public class ExerciseList extends AppCompatActivity {
    LinkedList<exerciseEntry> list;
    String defaultNew = "";
    private ListView exerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);
        list = new LinkedList<>();
        exerView = (ListView) findViewById(R.id.exerciseLV);
    }



    public void addEntry(View view) {
        EditText newEntry = (EditText) findViewById(R.id.newEntry);
        exerciseEntry entry = new exerciseEntry(newEntry.getText().toString());
        list.add(0, entry);

        newEntry.setText(defaultNew);

        LinkedList<String> exerName = new LinkedList<>();

        for (exerciseEntry e : list) {
            exerName.add(e.toString());
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
