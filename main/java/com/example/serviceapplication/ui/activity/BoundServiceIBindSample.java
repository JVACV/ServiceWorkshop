package com.example.serviceapplication.ui.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.serviceapplication.R;
import com.example.serviceapplication.data.DataProcessController;
import com.example.serviceapplication.service.LocalBoundService;


/**
 * @author dev.cobb
 * @version 1.0
 * @since 8 oct 2016
 */
public class BoundServiceIBindSample extends AppCompatActivity implements View.OnClickListener {
    LocalBoundService localBoundService;
    boolean isServiceBound = false;
    ServiceConnection serviceConnection;
    Intent serviceIntent;
    Button buttonStart, buttonStop, buttonBind, buttonUnbind, buttonGetNumber;
    TextView textViewRandomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_bound);
        serviceIntent = new Intent(this, LocalBoundService.class);

        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(this);

        buttonStop = (Button) findViewById(R.id.buttonStop);
        buttonStop.setOnClickListener(this);

        buttonBind = (Button) findViewById(R.id.buttonBind);
        buttonBind.setOnClickListener(this);

        buttonUnbind = (Button) findViewById(R.id.buttonUnbind);

        buttonUnbind.setOnClickListener(this);

        buttonGetNumber = (Button) findViewById(R.id.buttonGetNumber);
        buttonGetNumber.setOnClickListener(this);


        textViewRandomNumber = (TextView) findViewById(R.id.textviewRandomNumber);
    }


    /**
     * Defines callbacks for service binding, passed to bindService()
     */
    public void bindBoundService() {

        if (serviceConnection == null) {
            serviceConnection = new ServiceConnection() {

                @Override
                public void onServiceConnected(ComponentName className,
                                               IBinder service) {
                    // We've bound to LocalBoundService, cast the IBinder and get LocalBoundService instance
                    LocalBoundService.BinderService binder = (LocalBoundService.BinderService) service;
                    localBoundService = binder.getLocalBoundService();
                    isServiceBound = true;
                }

                @Override
                public void onServiceDisconnected(ComponentName arg0) {
                    isServiceBound = false;
                }


            };


        }
        bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    public void unbindBoundService() {


        if (isServiceBound) {
            unbindService(serviceConnection);
            isServiceBound = false;
        }


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.buttonStart:

                startService(serviceIntent);
                break;
            case R.id.buttonStop:
                stopService(serviceIntent);
                break;
            case R.id.buttonBind:
                bindBoundService();
                break;
            case R.id.buttonUnbind:
                unbindBoundService();
                break;
            case R.id.buttonGetNumber:
                if (isServiceBound) {
                    textViewRandomNumber.setText("Random number : " + localBoundService.getRandomNumber());
                } else {

                    textViewRandomNumber.setText("Service not bound");
                }
                break;

        }

    }

    @Override
    public void onBackPressed() {
        DataProcessController.getDataProcessController().getNavigator().navigateToHome(BoundServiceIBindSample.this);
    }
}
