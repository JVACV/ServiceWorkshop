package com.example.serviceapplication.ui.view;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;


/**
 * The type Vertical layout manager.
 * fix the orientation on recycler view
 *
 * @author dev.Cobb
 * @version 1.0
 * @since 8 oct 2016
 */
public class VerticalLayoutManager extends LinearLayoutManager {

    /**
     * Instantiates a new Vertical layout manager.
     *
     * @param context the context
     */
    public VerticalLayoutManager(Context context) {
        super(context);
        setOrientation(LinearLayoutManager.VERTICAL);
    }
}
