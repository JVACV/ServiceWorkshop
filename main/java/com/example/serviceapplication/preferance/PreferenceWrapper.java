package com.example.serviceapplication.preferance;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.serviceapplication.app.MyApp;


/**
 * The Class PreferenceWrapper for managing preference values.
 * inserting and retrieving values from preference.
 *
 * @author dev.Cobb
 * @version 1.0
 * @since 8 oct 2016
 *
 *
 */
public class PreferenceWrapper {

    /**
     * The application preference.
     */
    private SharedPreferences applicationPreference;

    /**
     * Instantiates a new application preference.
     */
   /* public PreferenceWrapper() {
        super();
        // TODO Auto-generated constructor stub
        applicationPreference = PreferenceManager
                .getDefaultSharedPreferences(MyApp.getContext());
    }*/

    /**
     * Put the string value in preference.
     *
     * @param key   the key
     * @param value the string value
     */
    public void putStringPref(String key, String value) {
        SharedPreferences.Editor editor = applicationPreference.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * Gets the string preference value.
     *
     * @param key      the key
     * @param defValue the default string value
     * @return the string value from preference
     */
    public String getStringPref(String key, String defValue) {
        return applicationPreference.getString(key, defValue);

    }

    /**
     * Put the integer value in preference.
     *
     * @param key   the key
     * @param value the integer value
     */
    public void putIntegerPref(String key, int value) {
        SharedPreferences.Editor editor = applicationPreference.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    /**
     * Gets the integer preference value.
     *
     * @param key      the key
     * @param defValue the default integer value
     * @return the integer value from preference
     */
    public int getIntegerPref(String key, int defValue) {
        return applicationPreference.getInt(key, defValue);
    }

    /**
     * Put the boolean value in preference.
     *
     * @param key   the key
     * @param value the boolean value
     */
    public void putBooleanPref(String key, boolean value) {
        SharedPreferences.Editor editor = applicationPreference.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * Gets the boolean preference value.
     *
     * @param key      the key
     * @param defValue the default boolean value
     * @return the boolean value from preference
     */
    public boolean getBooleanPref(String key, boolean defValue) {
        return applicationPreference.getBoolean(key, defValue);
    }

    /**
     * Put the long value in preference.
     *
     * @param key   the key
     * @param value the long value
     */
    public void putLongPref(String key, long value) {
        SharedPreferences.Editor editor = applicationPreference.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    /**
     * Gets the long preference value.
     *
     * @param key      the key
     * @param defValue the default long value
     * @return the long value from preference
     */
    public long getLongPref(String key, long defValue) {
        return applicationPreference.getLong(key, defValue);
    }

    /**
     * Put the float value in preference.
     *
     * @param key   the key
     * @param value the float value
     */
    public void putFloatPref(String key, float value) {
        SharedPreferences.Editor editor = applicationPreference.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    /**
     * Gets the float preference value.
     *
     * @param key      the key
     * @param defValue the default float value
     * @return the float value from preference
     */
    public float getFloatPref(String key, float defValue) {
        return applicationPreference.getFloat(key, defValue);
    }

    /**
     * Clear all preference.
     */
    public void clearAllPreference() {
        SharedPreferences.Editor editor = applicationPreference.edit();
        editor.clear();
    }
}
