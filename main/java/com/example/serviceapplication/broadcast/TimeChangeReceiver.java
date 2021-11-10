package com.example.serviceapplication.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.serviceapplication.ui.dialog.ToastHelper;


/**
 * @author dev.cobb
 * @version 1.0
 * @since 8 oct 2016
 */
public class TimeChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ToastHelper.show("Time Change");
    }
}
