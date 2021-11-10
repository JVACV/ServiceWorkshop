package com.example.serviceapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.serviceapplication.R;
import com.example.serviceapplication.data.DataProcessController;
import com.example.serviceapplication.service.MyIntentService;
import com.example.serviceapplication.service.SimpleService;


/**
 * Main class of this project
 *
 * @author dev.cobb
 * @version 1.0
 * @since 8 oct 2016
 */
public class Home extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "xzc";
    /**
     * The Button for start audio service.
     */
    Button buttonAudio;
    /**
     * The Button for start alarm service.
     */
    Button buttonAlarm;
    /**
     * The Button for start  a service using extend service class.
     */
    Button buttonSimpleService;
    /**
     * The Button for start  bound service using IBind.
     */
    Button buttonBoundServiceIBind;
    /**
     * The Button for start  bound service using  remote.
     */
    Button buttonBoundServiceRemote;
    /**
     * The Button for start  intent service using extend intent service .
     */
    Button buttonIntentService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // print the thread id of current working process
        Log.i(TAG, "home activity thread id " + Thread.currentThread().getId());
        attachView();

    }

    private  void attachView(){

        buttonAudio = (Button) findViewById(R.id.buttonAudio);
        buttonAudio.setOnClickListener(this);

        buttonAlarm = (Button) findViewById(R.id.buttonAlarm);
        buttonAlarm.setOnClickListener(this);

        buttonSimpleService = (Button) findViewById(R.id.buttonSimpleService);
        buttonSimpleService.setOnClickListener(this);

        buttonBoundServiceIBind = (Button) findViewById(R.id.buttonBoundServiceIBind);
        buttonBoundServiceIBind.setOnClickListener(this);

        buttonBoundServiceRemote = (Button) findViewById(R.id.buttonBoundServiceRemote);
        buttonBoundServiceRemote.setOnClickListener(this);

        buttonIntentService = (Button) findViewById(R.id.buttonIntentService);
        buttonIntentService.setOnClickListener(this);
    }


    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.buttonAudio:
                DataProcessController.getDataProcessController().getNavigator().navigateToAudio(Home.this);
                break;

            case R.id.buttonAlarm:
                DataProcessController.getDataProcessController().getNavigator().navigateToAlarm(Home.this);
                break;

            case R.id.buttonSimpleService:
                Intent intentIntentService = new Intent(Home.this, SimpleService.class);
                startService(intentIntentService);
                break;

            case R.id.buttonBoundServiceIBind:
                DataProcessController.getDataProcessController().getNavigator().navigateToBoundService(Home.this);
                break;

            case R.id.buttonIntentService:
                Intent intentSimpleService = new Intent(Home.this, MyIntentService.class);
                startService(intentSimpleService);
                break;

            case R.id.buttonBoundServiceRemote:
                DataProcessController.getDataProcessController().getNavigator().navigateToBoundServiceRemoteSample(Home.this);
                break;
        }
    }

}