package com.fiverr.foodwasteapp.activity.user.schedule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fiverr.foodwasteapp.R;
import com.fiverr.foodwasteapp.activity.user.list.ListFoundationActivity;
import com.fiverr.foodwasteapp.databinding.ActivityScheduleDonateUserBinding;
import com.fiverr.foodwasteapp.models.Business;
import com.fiverr.foodwasteapp.utils.Utils;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.util.Calendar;

public class ScheduleDonateUser extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = ScheduleDonateUser.class.getSimpleName();

    // Code to instance an unique ID of Pending Intent
    private static final int KEY_BROADCAST_CODE_ALARM = 767;
    // Create data Binding to instance the views from layout
    private ActivityScheduleDonateUserBinding binding;
    // Global Variable to save the state the date
    long dateSelected;
    // Global Variable to save the state of hour and minute
    int hourSelected, minuteSelected;

    // Init a Business Object to instance in all the Activity
    private Business mBusiness;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the arguments send by the before Activity
        Bundle bundle = getIntent().getExtras();
        // Verify if exists data sent
        if (bundle != null)
            // Get the Business Object
            mBusiness = (Business) bundle.getSerializable(ListFoundationActivity.class.getSimpleName());

        binding = DataBindingUtil.setContentView(this, R.layout.activity_schedule_donate_user);

        // Init Variable
        dateSelected = Calendar.getInstance().getTimeInMillis();
        hourSelected = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        minuteSelected = Calendar.getInstance().get(Calendar.MINUTE);

        binding.buttonRequestUser.setOnClickListener(this);
        binding.inputDateDelivery.setOnClickListener(this);
        binding.inputTimeDelivery.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        binding.textTitleFoundations.setText(mBusiness.getName());
    }

    /**
     * Override method to detect the clicks on views
     * @param view is the item that was clicked
     */
    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_request_user) {
            setAlarm(dateSelected, hourSelected, minuteSelected);

            // When click on input date,
        } else if (id == R.id.input_date_delivery) {
            // Create a date dialog picker
            MaterialDatePicker picker = builderMaterialDatePicker();
            // Show the dialog
            picker.show(getSupportFragmentManager(), picker.toString());
            // Listener to detect if the user select a date
            picker.addOnPositiveButtonClickListener(selection -> {
                // Selection is an Object class
                // It'll transform in long to set date in calendar
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis((long) selection);
                // IMPORTANT, here the calendar is added a day
                // because the selection object return the date with a day less
                cal.add(Calendar.DAY_OF_MONTH, 1);
                // Give an format date to better the visibility of date
                String date = Utils.formatLongDate(cal.getTime());
                // set time in the global variable
                dateSelected = cal.getTimeInMillis();
                // Set date on input
                binding.inputDateDelivery.setText(date);
            });
        } else if (id == R.id.input_time_delivery) {
            Calendar calendar = Calendar.getInstance();
            int hourActually = calendar.get(Calendar.HOUR_OF_DAY);
            int minActually = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    (timePicker, hour, minute) -> {
                        calendar.set(Calendar.MINUTE, minute);
                        calendar.set(Calendar.HOUR_OF_DAY, hour);
                        String timeFormat = Utils.formatSimpleTime(calendar.getTime());
                        // Set hour and minute selected by user
                        hourSelected = hour;
                        minuteSelected = minute;

                        binding.inputTimeDelivery.setText(timeFormat);
                    }, hourActually, minActually, false);
            timePickerDialog.show();
        }
    }


    /**
     * Build the type of MaterialDatePicker
     * more info:
     * https://github.com/material-components/material-components-android/blob/master/catalog/java/io/material/catalog/datepicker/DatePickerMainDemoFragment.java
     * @return MaterialDatePicker is the builder to create the dialog
     */
    private MaterialDatePicker builderMaterialDatePicker() {
        // Input method is the form how the date picker showing to user
        int inputMethod = MaterialDatePicker.INPUT_MODE_CALENDAR;
        // Create a builder
        MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
        // Init the dialog with the actually date
        builder.setSelection(MaterialDatePicker.todayInUtcMilliseconds());
        // set input Method to builder
        builder.setInputMode(inputMethod);
        // Return the builder that is constructed
        return builder.build();
    }

    /**
     * Set Alarm to send the foundation when user request
     * THis functions only execute offline form
     * @param date is the date that user set
     * @param hour is the hour that user set
     * @param minute is the minute that user set
     */
    private void setAlarm(long date, int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);

        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        // TODO: Here added an broadcast to set the date and time to sent notification to user through the server
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, KEY_BROADCAST_CODE_ALARM,
                new Intent(), 0);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }
}