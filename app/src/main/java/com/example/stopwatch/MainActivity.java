package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private long pauseoffset;
    private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = findViewById(R.id.clock);
        chronometer.setFormat("Time %s");

        Button play = findViewById(R.id.play1);
        Button pause = findViewById(R.id.pause1);
        Button reset = findViewById(R.id.hold1);

        play.setOnClickListener(this::start_chronometer);
        pause.setOnClickListener(this::pause_chronometer);
        reset.setOnClickListener(this::reset_chronometer);

    }
    public void start_chronometer(View v){
        if(!running){
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseoffset);
            chronometer.start();
            running = true;
        }
    }
    public void pause_chronometer(View v){
        if (running){
            chronometer.stop();
            pauseoffset = SystemClock.elapsedRealtime() -  chronometer.getBase();
            running = false;
        }
    }
    public void reset_chronometer(View v){
            chronometer.setBase(SystemClock.elapsedRealtime());
            pauseoffset = 0;
    }
}