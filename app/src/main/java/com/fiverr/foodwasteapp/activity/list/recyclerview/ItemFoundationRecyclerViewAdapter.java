package com.fiverr.foodwasteapp.activity.list.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fiverr.foodwasteapp.R;
import com.fiverr.foodwasteapp.models.Business;
import com.fiverr.foodwasteapp.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemFoundationRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // List of non-profit companies
    ArrayList<Business> listBusiness;
    // Context is to instance the activity with the item
    Context context;

    /**
     * Constructor to receive the list of Business
     * @param listBusiness list of Business (only non-profit companies)
     * @param context is the instance of Activity that called
     */
    public ItemFoundationRecyclerViewAdapter(Context context, ArrayList<Business> listBusiness) {
        this.listBusiness = listBusiness;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_recycler_view_list_foundation, parent, false);
        return new FoundationsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Business business = listBusiness.get(position);
        ((FoundationsViewHolder) holder).setFoundations(business);
    }

    @Override
    public int getItemCount() {
        return listBusiness.size();
    }

    class FoundationsViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageFoundation;
        private final ImageView iconStateConnection;
        public FoundationsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageFoundation = itemView.findViewById(R.id.image_business);
            iconStateConnection = itemView.findViewById(R.id.image_user_state);
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        void setFoundations(Business business) {
            Picasso.get().load(business.getUrlPicture())
                    .resize(100, 150)
                    .placeholder(context.getDrawable(R.drawable.ic_baseline_cloud_download))
                    .error(context.getDrawable(R.drawable.ic_baseline_image_black))
                    .into(imageFoundation);

            if(business.getUser() == null) return;

            Utils.changeColorState(context, business.getUser().getState(), iconStateConnection);
        }
    }
}
