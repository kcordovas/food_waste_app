package com.fiverr.foodwasteapp.activity.user.list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import com.fiverr.foodwasteapp.R;
import com.fiverr.foodwasteapp.activity.user.list.recyclerview.ItemFoundationRecyclerViewAdapter;
import com.fiverr.foodwasteapp.activity.user.schedule.ScheduleDonateUser;
import com.fiverr.foodwasteapp.databinding.ActivityListFoundationBinding;
import com.fiverr.foodwasteapp.models.Business;
import com.fiverr.foodwasteapp.models.User;

import java.util.ArrayList;

public class ListFoundationActivity extends AppCompatActivity {

    // Create a binding to instance of the views into the xml
    private ActivityListFoundationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_foundation);
        //setContentView(R.layout.activity_list_foundation);

        // To create an instance of
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.recyclerViewBusiness.setLayoutManager(linearLayoutManager);
        setRecyclerView();
    }

    private void setRecyclerView() {
        ArrayList<Business> listBusiness = new ArrayList<>();
        listBusiness.add(new Business("1", "Fundacion", "http://i.imgur.com/DvpvklR.png", 1, new User("123", "use", "pwd")));
        listBusiness.add(new Business("1", "Fundacion", "http://i.imgur.com/DvpvklR.png", 2, new User("123", "use", "pwd")));
        listBusiness.add(new Business("1", "Fundacion", "http://i.imgur.com/DvpvklR.png", 2, new User("123", "use", "pwd")));
        User user = new User("123", "user", "pwd");
        user.setState(0);
        listBusiness.add(new Business("1", "Fundacion", "http://i.imgur.com/DvpvklR.png", 3, user));
        listBusiness.add(new Business("1", "Fundacion", "http://i.imgur.com/DvpvklR.png", 3, user));

        ItemFoundationRecyclerViewAdapter adapter = new ItemFoundationRecyclerViewAdapter(this, listBusiness);
        
        binding.recyclerViewBusiness.setAdapter(adapter);
        binding.recyclerViewBusiness.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return true;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                Intent intent = new Intent(ListFoundationActivity.this, ScheduleDonateUser.class);
                startActivity(intent);
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });
    }
}