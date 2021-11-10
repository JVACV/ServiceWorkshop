package com.example.serviceapplication.ui.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.serviceapplication.R;
import com.example.serviceapplication.broadcast.AlarmBroadcastReceiver;
import com.example.serviceapplication.data.DataProcessController;
import com.example.serviceapplication.ui.dialog.ToastHelper;


/**
 * The type My alarm.
 *
 * @author dev.cobb
 * @version 1.0
 * @since 8 oct 2016
 */
public class MyAlarm extends AppCompatActivity implements View.OnClickListener {
    /**
     * The Button alarm.
     */
    Button buttonAlarm;
    /**
     * The Edit text time.
     */
    EditText editTextTime;

    AlarmBroadcastReceiver alarmBroadcastReceiver;
@Override
public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

    buttonAlarm = (Button) findViewById(R.id.buttonSetAlarm);
    buttonAlarm.setOnClickListener(this);

    editTextTime= (EditText) findViewById(R.id.editTextTime);

    alarmBroadcastReceiver=new AlarmBroadcastReceiver();

        }
public void onClick(View src) {
        switch (src.getId()) {
        case R.id.buttonSetAlarm:

            startAlert();
            break;
        }
        }


    /**
     * Start alert.
     */
    public void startAlert() {

        int i = Integer.parseInt(editTextTime.getText().toString());
        Intent intent = new Intent(this, AlarmBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (i * 1000), pendingIntent);

//        ToastHelper.show( "MyAlarm set in " + i + " seconds");
    }

    @Override
    public void onBackPressed() {
        DataProcessController.getDataProcessController().getNavigator().navigateToHome(MyAlarm.this);
        finish();
    }


    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter("");
        registerReceiver(alarmBroadcastReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(alarmBroadcastReceiver);
    }
}