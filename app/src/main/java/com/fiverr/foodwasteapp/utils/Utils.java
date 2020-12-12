package com.fiverr.foodwasteapp.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

import com.fiverr.foodwasteapp.R;

import java.text.DateFormat;
import java.util.Date;

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

    /**
     * Get in text, the type of business
     * @param context is the activity that require this
     * @param type is the type of business in number (more info, review the Object Business) (foundation, charity organizations)
     * @return String type of Business
     */
    public static String typeOrganizations(Context context, int type) {
        Resources resources = context.getResources();
        switch (type) {
            case 1:
                return resources.getString(R.string.charity_organization);
            case 2:
                return resources.getString(R.string.foundations);
            case 3:
                return resources.getString(R.string.homeless_shelters);
            default:
                return resources.getString(R.string.business);

        }
    }

    /**
     * Transform date in String to better the visibility
     * Example: January 12, 1952
     * @param date is the Date class to transform
     * @return string date format to use in either code place
     */
    public static String formatLongDate(Date date) {
        return DateFormat.getDateInstance(DateFormat.LONG).format(date);
    }

    /**
     * Transform the time to String to better the visibility
     * Example: 14:20
     * @param date is the Date that contains the time (hour and minute)
     * @return string time format to use in either code place
     */
    public static String formatSimpleTime(Date date) {
        return DateFormat.getTimeInstance(DateFormat.SHORT).format(date);
    }
}
