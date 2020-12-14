package com.fiverr.foodwasteapp.activity.foundations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.fiverr.foodwasteapp.R;
import com.fiverr.foodwasteapp.activity.foundations.dialogs.NoteDeniedDialog;
import com.fiverr.foodwasteapp.activity.foundations.recyclerviews.ListRequestUserRecyclerAdapter;
import com.fiverr.foodwasteapp.databinding.ActivityListRequestUserBinding;
import com.fiverr.foodwasteapp.models.Business;
import com.fiverr.foodwasteapp.models.Order;
import com.fiverr.foodwasteapp.models.Person;
import com.fiverr.foodwasteapp.models.decorator.MyOrder;
import com.fiverr.foodwasteapp.models.decorator.OrderApproved;
import com.fiverr.foodwasteapp.models.decorator.OrderDenied;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.Date;

public class ListRequestUserActivity extends AppCompatActivity {

    private static final String TAG = ListRequestUserActivity.class.getSimpleName();
    // Create data binding to instance of layout and their views
    private ActivityListRequestUserBinding binding;
    private ListRequestUserRecyclerAdapter adapter;
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
        Order order = new Order("123", business, person, dateDelivery,timeDelivery);

        adapter = new ListRequestUserRecyclerAdapter(this, listOrder,
                new ListRequestUserRecyclerAdapter.ICLickListener() {
                    MyOrder myOrder;
                    OrderApproved orderApproved;
                    @Override
                    public void approvedRequest(int position) {
                        DialogFullScreenFoundationVerificationCode dialog = new DialogFullScreenFoundationVerificationCode();
                        Bundle bundle = new Bundle();
                        bundle.putString(dialog.getTag(), orderApproved.getVerificationCode());
                        dialog.setArguments(bundle);
                        dialog.show(getSupportFragmentManager(), dialog.getTag());
                    }

                    @Override
                    public void onApprove(View view, int position) {
                        myOrder = new MyOrder();
                        myOrder.createOrder(listOrder.get(position));
                        orderApproved = new OrderApproved(myOrder);
                        orderApproved.createOrder(listOrder.get(position));
                    }

                    @Override
            public void onDenied(View view, int position) {
                NoteDeniedDialog dialog = new NoteDeniedDialog(ListRequestUserActivity.this,
                        new MaterialAlertDialogBuilder(ListRequestUserActivity.this),
                        message -> {
                            myOrder = new MyOrder();
                            myOrder.createOrder(listOrder.get(position));
                            OrderDenied orderDenied = new OrderDenied(myOrder);
                            orderDenied.createOrder(listOrder.get(position));
                            orderDenied.setNoteDenied(message);
                            Log.d(TAG, "onDenied: " + orderDenied.getNoteDenied());
                            listOrder.remove(position);
                            adapter.notifyDataSetChanged();
                        });
                dialog.show();
            }
        });
        binding.recyclerViewRequestList.setAdapter(adapter);
    }


}