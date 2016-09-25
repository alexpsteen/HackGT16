package com.example.alexsteen.hackgt16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.graphics.Typeface;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
//what dis

    //<333333
    //crying
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = (Button)findViewById(R.id.button2);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Cabin-Regular.ttf");
        login.setTypeface(custom_font);

        Button register = (Button)findViewById(R.id.button);
        Typeface custom_font2 = Typeface.createFromAsset(getAssets(), "fonts/Cabin-Regular.ttf");
        register.setTypeface(custom_font2);


    }

    public void goToLoginScreen(View view) {
        Intent i = new Intent(this, Checklist.class);
        startActivity(i);
    }


}
