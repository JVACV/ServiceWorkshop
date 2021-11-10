package com.example.serviceapplication.ui.navigator;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.serviceapplication.ui.activity.BoundServiceIBindSample;
import com.example.serviceapplication.ui.activity.BoundServiceRemoteSample;
import com.example.serviceapplication.ui.activity.Home;
import com.example.serviceapplication.ui.activity.MyAlarm;
import com.example.serviceapplication.ui.activity.MyAudio;
import com.example.serviceapplication.ui.activity.Next;


/**
 * @author dev.Cobb
 * @version 1.0
 * @since 8 oct 2016S
 */
public class Navigator {

    /** activity_bind_bound navigate method : you can navigate from any activity to class TargetActivity.class
     *
     * @param activity the class you can start your activity
     *
     **/

    public void navigateToAudio(AppCompatActivity activity) {
        Intent intent = new Intent(activity, MyAudio.class);
        activity.startActivity(intent);
        activity.finish();}


    public void navigateToAlarm(AppCompatActivity activity) {
        Intent intent = new Intent(activity, MyAlarm.class);
        activity.startActivity(intent);
        activity.finish();}

    public void navigateToNext(AppCompatActivity activity) {
        Intent intent = new Intent(activity, Next.class);
        activity.startActivity(intent);
        activity.finish();}

    public void navigateToHome(AppCompatActivity activity) {
        Intent intent = new Intent(activity, Home.class);
        activity.startActivity(intent);
        activity.finish();}
    public void navigateToBoundService(AppCompatActivity activity) {
        Intent intent = new Intent(activity, BoundServiceIBindSample.class);
        activity.startActivity(intent);
        activity.finish();}

    public void navigateToBoundServiceRemoteSample(AppCompatActivity activity) {
        Intent intent = new Intent(activity, BoundServiceRemoteSample.class);
        activity.startActivity(intent);
        activity.finish();}

}

