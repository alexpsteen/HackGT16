package com.example.alexsteen.hackgt16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.LinkedList;

/**
 * Created by Alex Steen on 9/24/2016.
 */
public class Checklist extends AppCompatActivity {
    private LinkedList<Elist> checklist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);
        checklist = new LinkedList<>();
    }

    public void addEntry(View view) {
        EditText name = (EditText) findViewById(R.id.elistTB);

        Elist e = new Elist(name.getText().toString());
        checklist.add(e);
    }

}
