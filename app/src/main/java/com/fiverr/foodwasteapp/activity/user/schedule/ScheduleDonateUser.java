package com.fiverr.foodwasteapp.activity.user.schedule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.fiverr.foodwasteapp.R;
import com.fiverr.foodwasteapp.databinding.ActivityScheduleDonateUserBinding;
import com.fiverr.foodwasteapp.utils.Utils;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.util.Calendar;

public class ScheduleDonateUser extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = ScheduleDonateUser.class.getSimpleName();
    // Create data Binding to instance the views from layout
    private ActivityScheduleDonateUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_schedule_donate_user);

        binding.buttonRequestUser.setOnClickListener(this);
        binding.inputDateDelivery.setOnClickListener(this);
        binding.inputTimeDelivery.setOnClickListener(this);
    }

    /**
     * Override method to detect the clicks on views
     * @param view is the item that was clicked
     */
    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_request_user) {
            Log.d(TAG, "onClick: Button request");
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
}