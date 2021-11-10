package com.example.serviceapplication.data;


import com.example.serviceapplication.preferance.AppPreferences;
import com.example.serviceapplication.ui.navigator.Navigator;

/**
 * The type Data process controller.
 *
 * @author dev.Cobb
 * @version 1.0
 * @since 8 oct 2016
 *
 * DataProcessController is use to control data flow of our project ,  eg : Data Base preference etc initial here
 */
public class DataProcessController {

    private static volatile DataProcessController instance = null;
//    private final AppPreferences appPreference = new AppPreferences();
    private final Navigator navigator = new Navigator();


    /**
     * Gets data process controller.
     *
     * @return instance the data process controller
     */
    public static DataProcessController getDataProcessController() {
        if (instance == null) {
            // double check
            synchronized (DataProcessController.class) {
                if (instance == null) {
                    instance = new DataProcessController();
                }
            }
        }
        return instance;
    }

    /**
     * Gets preference.
     *
     * @return instance the preference
     */
//    public AppPreferences getPreference() {
//        return appPreference;
//    }

    /**
     * Gets navigator.
     *
     * @return instance the navigator
     */
    public Navigator getNavigator() {
        return navigator;
    }



}
