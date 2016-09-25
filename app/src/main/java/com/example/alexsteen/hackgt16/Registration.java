package com.example.alexsteen.hackgt16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class Registration extends AppCompatActivity {

    boolean consultant;
    private userDB db;
    private FitnessDB fitdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        consultant = false;

        db = new userDB(this);
        EditText e = (EditText) findViewById(R.id.usernameblank2) ;
        fitdb = new FitnessDB(this, e.getText().toString());
    }

    public boolean consCheck() {
        CheckBox cb = (CheckBox) findViewById(R.id.consultant);
        if (cb.isChecked()) {
            return true;
        } else {
            return false;
        }
    }

    public void goToWelcomeScreen(View view) {
        Intent i = new Intent(this, WelcomeScreen.class);
        startActivity(i);
    }

}
