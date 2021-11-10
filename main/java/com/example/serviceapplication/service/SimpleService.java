package com.example.serviceapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import android.util.Log;

import androidx.annotation.Nullable;

import com.example.serviceapplication.app.MyApp;


/**
 * The type Simple service.
 *
 * @author dev.cobb
 * @version 1.0
 * @since 8 oct 2016
 */
public class SimpleService extends Service{


    /**
     * NO rolls in a simple service
     *
     * The system invokes this method by calling bindService() when another component wants
     * to bind with the service (such as to perform RPC). In your implementation of this method, you must provide an interface
     * that clients use to communicate with the service by returning an IBinder. You must always implement this method; however,
     * if you don't want to allow binding, you should return null.
    }
     * */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    /**
     * the method onCreate
     *
     * The system invokes this method to perform one-time setup procedures when the service is initially created
     * (before it calls either onStartCommand() or onBind()). If the service is already running, this method is not called.

     * */
    @Override
    public void onCreate()
    {
        super.onCreate();
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
        Log.i(MyApp.TAG,"SimpleService activity thread id "+Thread.currentThread().getId());
        stopSelf();
        return START_STICKY;
    }


    /***
     * The system invokes this method when the service is no longer used and is being destroyed.
     * Your service should implement this to clean up any resources such as threads, registered listeners,
     * or receivers. This is the last call that the service receives.
     *
     */

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(MyApp.TAG,"Stop service");
    }
}
