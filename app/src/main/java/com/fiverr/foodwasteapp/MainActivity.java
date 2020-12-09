package com.fiverr.foodwasteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.fiverr.foodwasteapp.activity.list.ListFoundationActivity;
import com.fiverr.foodwasteapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.buttonSignIn.setOnClickListener(view -> {
            final Intent intent = new Intent(this, ListFoundationActivity.class);
            startActivity(intent);
        });
    }
}