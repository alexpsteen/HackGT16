package com.example.alexsteen.hackgt16;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FitnessHomepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_homepage);
    }

    public void goToChecklist(View view) {
        Intent intent = new Intent(this, Checklist.class);
        startActivity(intent);
    }

    public void goToTimer(View view) {
        Intent intent = new Intent(this, Timer.class);
        startActivity(intent);
    }

}
