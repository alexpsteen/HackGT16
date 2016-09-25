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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        consultant = false;
        db = new userDB(this);
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

    public void createUser() {
        EditText aName = (EditText)findViewById(R.id.fullnameblank);
        EditText aUserName = (EditText)findViewById(R.id.usernameblank2);
        EditText aPassWord = (EditText)findViewById(R.id.passwordblank2);
        EditText aAge = (EditText)findViewById(R.id.ageblank);
        EditText aFeet = (EditText)findViewById(R.id.feetblank);
        EditText aInches = (EditText)findViewById(R.id.inchesblank);
        EditText aWeight = (EditText)findViewById(R.id.weightblank);

        String n = aName.getText().toString();
        String un = aUserName.getText().toString();
        String pw = aPassWord.getText().toString();
        int a = Integer.parseInt(aAge.getText().toString());
        String ft = Integer.parseInt(aFeet.getText().toString());
        String in = Integer.parseInt(aInches.getText().toString());
        int wt = Integer.parseInt(aWeight.getText().toString());
        boolean aConsultant = consCheck();

        User newUser = User(n,un,pw,)


    }



}
