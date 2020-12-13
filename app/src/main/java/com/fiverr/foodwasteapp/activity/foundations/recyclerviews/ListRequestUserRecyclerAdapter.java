package com.fiverr.foodwasteapp.activity.foundations.recyclerviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fiverr.foodwasteapp.R;
import com.fiverr.foodwasteapp.models.Order;
import com.fiverr.foodwasteapp.models.decorator.OrderApproved;
import com.fiverr.foodwasteapp.utils.Utils;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Date;

public class ListRequestUserRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // Create an context variable to instance the activity that created the recycler view
    private final Context context;
    // Create an Order list to add for the recycler view adapter
    private final ArrayList<Order> listOrder;
    // Instance the Listener to detect which button is clicked
    ICLickListener listener;

    public ListRequestUserRecyclerAdapter(Context context, ArrayList<Order> listOrder) {
        this.context = context;
        this.listOrder = listOrder;
    }

    public ListRequestUserRecyclerAdapter(Context context, ArrayList<Order> listOrder, ICLickListener listener) {
        this.context = context;
        this.listOrder = listOrder;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_recycler_view_request_user, parent, false);
        return new ItemRequestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Order order = listOrder.get(position);
        ItemRequestViewHolder itemRequestViewHolder = (ItemRequestViewHolder) holder;
        itemRequestViewHolder.setOrderItem(order);
        itemRequestViewHolder.buttonDeny.setOnClickListener(view -> listener.onDenied(view, position));
        itemRequestViewHolder.buttonApprove.setOnClickListener(view -> {
            itemRequestViewHolder.buttonVerificationCode.setVisibility(View.VISIBLE);
            itemRequestViewHolder.buttonDeny.setVisibility(View.GONE);
            itemRequestViewHolder.buttonApprove.setVisibility(View.GONE);
            listener.onApprove(view, position);
            this.notifyDataSetChanged();
        });
        itemRequestViewHolder.buttonVerificationCode.setOnClickListener(view -> listener.approvedRequest(position));
    }

    @Override
    public int getItemCount() {
        return listOrder.size();
    }

    class ItemRequestViewHolder extends RecyclerView.ViewHolder {
        private final TextView textUserName;
        private final TextView textDate;
        private final TextView textTime;
        public final MaterialButton buttonDeny;
        public final MaterialButton buttonApprove;
        public final MaterialButton buttonVerificationCode;

        public ItemRequestViewHolder(@NonNull View itemView) {
            super(itemView);
            textUserName = itemView.findViewById(R.id.text_user_name_item);
            textDate = itemView.findViewById(R.id.text_date_item);
            textTime = itemView.findViewById(R.id.text_time_item);
            buttonApprove = itemView.findViewById(R.id.button_approve_item);
            buttonDeny = itemView.findViewById(R.id.button_deny_item);
            buttonVerificationCode = itemView.findViewById(R.id.button_view_verification_code);
        }

        void setOrderItem(Order orderItem) {
            Date date = new Date();
            date.setTime(orderItem.getDateDelivery());
            textUserName.setText(orderItem.getPerson().getName());
            textDate.setText(Utils.formatLongDate(date));
            date.setTime(orderItem.getTimeDelivery());
            textTime.setText(Utils.formatLongDate(date));
        }
    }

    /**
     * Interface Click Listener to detect when user clicked on buttons
     */
    public interface ICLickListener {
        // method use to when clicked on Approve Button
        void onApprove(View view, int position);
        // method use to when clicked on Denied Button
        void onDenied(View view, int position);
        // method when user approved the request
        void approvedRequest(int position);
    }
}
