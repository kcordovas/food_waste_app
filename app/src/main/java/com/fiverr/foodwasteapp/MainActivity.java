package com.fiverr.foodwasteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import com.fiverr.foodwasteapp.activity.foundations.ListRequestUserActivity;
import com.fiverr.foodwasteapp.activity.user.list.ListFoundationActivity;
import com.fiverr.foodwasteapp.controller.UserController;
import com.fiverr.foodwasteapp.controller.interfaces.IUserView;
import com.fiverr.foodwasteapp.databinding.ActivityMainBinding;
import com.fiverr.foodwasteapp.models.User;

public class MainActivity extends AppCompatActivity implements IUserView, View.OnClickListener {
    // Create a constant for reference the shared preferences
    // about the numbers of times that user fail in login
    private static final String KEY_COUNT_LOGIN_ERROR = "count_login_error";
    // Init the binding to instance the XML layout with the Java Class
    private ActivityMainBinding binding;
    // Init the controller to make actions on the data
    private UserController userController;
    // Init the preferences
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Init the binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Instance the shared preferences value to use
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        // Instance the UserController
        userController = new UserController(this);


        // Set CLick listener on buttons and other actions
        binding.buttonSignIn.setOnClickListener(this);

        binding.textFoundation.setOnClickListener(view -> {
            final Intent intent = new Intent(this, ListRequestUserActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onSuccessLogin(User user) {
        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
        // Create an explicit Intent to init the ListFoundationActivity
        Intent intent = new Intent(this, ListFoundationActivity.class);
        Bundle bundle = new Bundle();
        // Send the user for the activity
        bundle.putSerializable(MainActivity.class.getSimpleName(), user);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onFailLogin(String message) {
        // Get the count the fails login
        int countActuallyFails = preferences.getInt(KEY_COUNT_LOGIN_ERROR, 1);
        // to compare with if it was more than three
        if (countActuallyFails > 3) {
            Toast.makeText(this, "Error, number of failed attempts passed", Toast.LENGTH_SHORT).show();
            return;
        }
        // Else add an failLogin
        countActuallyFails += 1;
        SharedPreferences.Editor editorPreferences = preferences.edit();
        editorPreferences.putInt(KEY_COUNT_LOGIN_ERROR, countActuallyFails);
        editorPreferences.apply();

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        int idView = view.getId();
        if (idView == binding.buttonSignIn.getId()) {
            String user = binding.inputUserName.getText().toString();
            String pwd = binding.inputPwd.getText().toString();
            userController.onLogin(user, pwd);
        }
    }
}