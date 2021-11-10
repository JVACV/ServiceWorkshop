package com.example.serviceapplication.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.serviceapplication.R;
import com.example.serviceapplication.ui.dialog.ToastHelper;


/**
 * @author dev.cobb
 * @version 1.0
 * @since 8 oct 2016
 */
public class AudioService extends Service {
    MediaPlayer myPlayer;
    /**
     * the method onCreate
     *
     * The system invokes this method to perform one-time setup procedures when the service is initially created
     * (before it calls either onStartCommand() or onBind()). If the service is already running, this method is not called.

     * */

    @Override
    public void onCreate() {
        super.onCreate();
    }
    /**
     * NO rolls in a simple service
     *
     * The system invokes this method by calling bindService() when another component wants
     * to bind with the service (such as to perform RPC). In your implementation of this method, you must provide an interface
     * that clients use to communicate with the service by returning an IBinder. You must always implement this method; however,
     * if you don't want to allow binding, you should return null.
     }
     * */

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /***
     *
     * The system invokes this method by calling startService() when another component (such as an activity)
     * requests that the service be started. When this method executes, the service is started and can run in
     * the background indefinitely. If you implement this, it is your responsibility to stop the service when
     * its work is complete by calling stopSelf() or stopService(). If you only want to provide binding, you don't need
     * to implement this method.
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        ToastHelper.show("Service Started");
        myPlayer = MediaPlayer.create(this, R.raw.sun);
        myPlayer.setLooping(false); // Set looping
        myPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }
    /***
     * The system invokes this method when the service is no longer used and is being destroyed.
     * Your service should implement this to clean up any resources such as threads, registered listeners,
     * or receivers. This is the last call that the service receives.
     *
     */
    @Override
    public void onDestroy() {
//        ToastHelper.show("Service Stopped");
        myPlayer.stop();
    }
}