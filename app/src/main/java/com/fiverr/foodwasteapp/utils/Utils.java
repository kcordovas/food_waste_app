package com.fiverr.foodwasteapp.utils;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

import com.fiverr.foodwasteapp.R;

/**
 * Utils class is to instance method in all classes
 * This methods'll use to either class, activity or others
 */
public class Utils {

    /**
     * Change colorState is use to make change color of
     * state
     * 1 - Connected -> Green Color
     * 0 - Inactive -> Gray Color
     * @param context is who instance the method
     * @param state is the user state
     * @param view is the view that change shape of color
     */
    public static void changeColorState(Context context, int state, View view) {
        // Create an GradientDrawable
        // because the view'll have a shape, it saved in drawable how shape_..
        GradientDrawable background = (GradientDrawable) view.getBackground();
        // To init the state is Connected
        int colorState = R.color.colorConnectedStatus;
        if (background != null) {
            // if tHe state is inactive
            // change color to Gray Color
            if (state == 0)
                colorState = R.color.dividerColor;
            // Finally, set color on the shape and it on the view
            background.setColor(context.getColor(colorState));
        }
    }
}
