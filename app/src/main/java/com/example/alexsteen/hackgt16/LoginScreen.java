package com.example.alexsteen.hackgt16;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.widget.Toast;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {

    String username;
    String password;
    Toast toast;
    private SharedPreferences.Editor editCurrentUser;
    private SharedPreferences currentUser;
    private userDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        currentUser = getSharedPreferences("CurrentUser", MODE_PRIVATE);
        editCurrentUser = currentUser.edit();
        editCurrentUser.apply();
        db = new userDB(this);

    }

    public void goToWelcomeScreen(View view) throws Exception{
        System.out.println(validator());
        if (validator()) {
            Intent i = new Intent(this, WelcomeScreen.class);
            startActivity(i);
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Invalid username or password, please try again.";
            int duration = Toast.LENGTH_SHORT;

            toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    private boolean validator() throws Exception{
        EditText user = (EditText) findViewById(R.id.usernameblank);
        EditText pass = (EditText) findViewById(R.id.passwordblank);
        String username = user.getText().toString();
        String password = pass.getText().toString();
        System.out.println("Username: " + username + " and password is " + password);
        boolean x = db.authenticateUser(username,password);
        return x;


//        if (user.getText().toString().equals(u)) {
//            if (pass.getText().toString().equals(p)) {
//                editCurrentUser.putString("username", user.getText().toString());
//                editCurrentUser.commit();
//                return true;
//            }
//        }
//        return false;
    }
}
