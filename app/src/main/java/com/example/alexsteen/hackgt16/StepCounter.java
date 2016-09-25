package com.example.alexsteen.hackgt16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.LinkedList;

public class StepCounter extends AppCompatActivity {
    private LinkedList<Integer> oldSteps;
    private TextView stepTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stepcounter);
        stepTV = (TextView) findViewById(R.id.stepCounter);
        stepTV.setText("0");
    }


}
