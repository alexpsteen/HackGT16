package com.example.alexsteen.hackgt16;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

public class Timer extends AppCompatActivity {

    private Chronometer chronometer;
    private boolean isRunning;
    private long timeStopped = 0;
    private boolean isReset = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        chronometer = (Chronometer) findViewById(R.id.chronometer);
    }

    public void resetTime(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        timeStopped = 0;
        isReset=true;
    }
    public void startTime(View v){
        if(isReset) {
            chronometer.setBase(SystemClock.elapsedRealtime() - timeStopped);
            chronometer.start();
            isRunning = true;
        }
    }

    public void stopTime(View v) {
        if(isRunning) {
            timeStopped = (chronometer.getBase()-SystemClock.elapsedRealtime());
            int seconds = Math.abs((int)timeStopped/1000);
            System.out.println(seconds);
            chronometer.stop();
            isRunning = false;
            isReset = false;
        }
    }

}
