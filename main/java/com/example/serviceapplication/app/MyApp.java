package com.example.serviceapplication.app;

import android.app.Application;

/**
 * The Class MyApp.
 *
 * @author dev.Cobb
 * @version 1.0
 * @since 8 oct 2016
 *
 */


public class MyApp extends Application {

    /**
     * The Constant TAG.
     */
    public static final String TAG = MyApp.class.getSimpleName();

    /**
     * The application instance.
     */
    private static MyApp instance = null;

    /**
     * (non-Javadoc)
     *
     * @see Application#onCreate()
     */
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();

        instance = this;

    }

    /**
     * Gets the context.
     *
     * @return the context
     */
    public static synchronized MyApp getContext() {
        if (instance == null) {
            synchronized (MyApp.class) {
                if (instance == null) {
                    instance = new MyApp();
                }
            }
        }
        return instance;
    }


}

