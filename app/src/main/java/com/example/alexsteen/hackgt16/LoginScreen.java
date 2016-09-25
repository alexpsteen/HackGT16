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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        currentUser = getSharedPreferences("CurrentUser", MODE_PRIVATE);
        editCurrentUser = currentUser.edit();
        editCurrentUser.apply();

        username = "aliciachan";
        password = "12345";

    }

    public void goToWelcomeScreen(View view) {
        if (validator(username, password)) {
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

    private boolean validator(String u, String p) {
        EditText user = (EditText) findViewById(R.id.usernameblank);
        EditText pass = (EditText) findViewById(R.id.passwordblank);

        if (user.getText().toString().equals(u)) {
            if (pass.getText().toString().equals(p)) {
                editCurrentUser.putString("username", user.getText().toString());
                editCurrentUser.commit();
                return true;
            }
        }
        return false;
    }
}
