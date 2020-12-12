package com.fiverr.foodwasteapp.activity.foundations.recyclerviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fiverr.foodwasteapp.R;

public class ListRequestUserRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // Create an context variable to instance the activity that created the recycler view
    private Context context;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_recycler_view_request_user, parent, false);
        return new ItemRequestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ItemRequestViewHolder extends RecyclerView.ViewHolder {
        private final TextView textUserName;
        private final TextView textDate;
        private final TextView textTime;

        public ItemRequestViewHolder(@NonNull View itemView) {
            super(itemView);
            textUserName = itemView.findViewById(R.id.text_user_name_item);
            textDate = itemView.findViewById(R.id.text_date_item);
            textTime = itemView.findViewById(R.id.text_time_item);

        }
    }
}
