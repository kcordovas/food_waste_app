package com.fiverr.foodwasteapp.activity.foundations;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.fiverr.foodwasteapp.R;
import com.fiverr.foodwasteapp.activity.foundations.recyclerviews.ListRequestUserRecyclerAdapter;
import com.fiverr.foodwasteapp.databinding.ActivityListRequestUserBinding;
import com.fiverr.foodwasteapp.models.Business;
import com.fiverr.foodwasteapp.models.Order;
import com.fiverr.foodwasteapp.models.Person;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.Date;

public class ListRequestUserActivity extends AppCompatActivity {

    private static final String TAG = ListRequestUserActivity.class.getSimpleName();
    // Create data binding to instance of layout and their views
    private ActivityListRequestUserBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_request_user);

        final LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.recyclerViewRequestList.setLayoutManager(manager);
        addOrders();
    }

    private void addOrders() {
        Date date = new Date();
        long dateDelivery = date.getTime();
        long timeDelivery = new Date().getTime();
        Person person = new Person("123", "Usuario");
        Business business = new Business("123", "A good Friend", "url", 0);
        ArrayList<Order> listOrder = new ArrayList<>();
        listOrder.add(new Order("123", business, person, dateDelivery,timeDelivery));
        person.setName("User 2");
        listOrder.add(new Order("123", business, person, dateDelivery,timeDelivery));
        person.setName("User 3");
        listOrder.add(new Order("123", business, person, dateDelivery, timeDelivery));
        listOrder.add(new Order("123", business, person, dateDelivery,timeDelivery));

        ListRequestUserRecyclerAdapter adapter = new ListRequestUserRecyclerAdapter(this, listOrder,
                new ListRequestUserRecyclerAdapter.ICLickListener() {
            @Override
            public void onApprove(View view, int position) {
                Log.d(TAG, "onApprove: " + position);
            }

            @Override
            public void onDenied(View view, int position) {
                Log.d(TAG, "onDenied: " + position);
            }
        });
        binding.recyclerViewRequestList.setAdapter(adapter);
    }


}