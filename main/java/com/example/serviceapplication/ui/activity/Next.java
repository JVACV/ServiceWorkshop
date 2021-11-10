package com.example.serviceapplication.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.serviceapplication.R;
import com.example.serviceapplication.data.DataProcessController;


/**
 * The type Next is a simple activity to show a service working back ground.
 *
 * @author dev.cobb
 * @version 1.0
 * @since 8 oct 2016
 */
public class Next extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(dev.cobbb.servicetest.R.layout.activity_next);
        setContentView(R.layout.activity_next);
    }


    @Override
    public void onBackPressed() {
        DataProcessController.getDataProcessController().getNavigator().navigateToHome(Next.this);
    }
}
