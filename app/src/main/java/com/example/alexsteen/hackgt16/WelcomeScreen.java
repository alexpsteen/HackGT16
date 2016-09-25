package com.example.alexsteen.hackgt16;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
    }

    public void goToFitnessWelcome(View view) {
        Intent intent = new Intent(this, FitnessHomepage.class);
        startActivity(intent);
    }

}
