package com.example.serviceapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.serviceapplication.R;
import com.example.serviceapplication.data.DataProcessController;
import com.example.serviceapplication.service.AudioService;


/**
 * The type My audio.
 *
 * @author dev.cobb
 * @version 1.0
 * @since 8 oct 2016
 *
 */
public class MyAudio extends AppCompatActivity implements View.OnClickListener {
    /**
     * The Button start.
     */
    Button buttonStart, /**
     * The Button stop.
     */
    buttonStop, /**
     * The Button next.
     */
    buttonNext;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_audio);

            buttonStart = (Button) findViewById(R.id.buttonStart);
            buttonStart.setOnClickListener(this);
            buttonStop = (Button) findViewById(R.id.buttonStop);
            buttonStop.setOnClickListener(this);
            buttonNext = (Button) findViewById(R.id.buttonNext);
            buttonNext.setOnClickListener(this);
        }
    public void onClick(View src) {
        switch (src.getId()) {
            case R.id.buttonStart:
                startService(new Intent(this, AudioService.class));
                break;
            case R.id.buttonStop:
                stopService(new Intent(this, AudioService.class));
                break;
            case R.id.buttonNext:
                Intent intent=new Intent(this,Next.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        DataProcessController.getDataProcessController().getNavigator().navigateToHome(MyAudio.this);
    }
}