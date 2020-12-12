package com.fiverr.foodwasteapp.activity.foundations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.fiverr.foodwasteapp.R;
import com.fiverr.foodwasteapp.activity.foundations.recyclerviews.ListRequestUserRecyclerAdapter;
import com.fiverr.foodwasteapp.databinding.ActivityListRequestUserBinding;
import com.fiverr.foodwasteapp.models.Business;
import com.fiverr.foodwasteapp.models.Order;
import com.fiverr.foodwasteapp.models.Person;

import java.util.ArrayList;
import java.util.Date;

public class ListRequestUserActivity extends AppCompatActivity {

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

        ListRequestUserRecyclerAdapter adapter = new ListRequestUserRecyclerAdapter(this, listOrder);
        binding.recyclerViewRequestList.setAdapter(adapter);
    }


}