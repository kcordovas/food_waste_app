package com.fiverr.foodwasteapp.activity.foundations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.fiverr.foodwasteapp.R;
import com.fiverr.foodwasteapp.databinding.ActivityListRequestUserBinding;

public class ListRequestUserActivity extends AppCompatActivity {

    // Create data binding to instance of layout and their views
    private ActivityListRequestUserBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_request_user);
    }
}