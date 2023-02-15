package com.circle.foodpickup.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.circle.foodpickup.R;
import com.circle.foodpickup.activity.RestoMenuActivity;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class OrderStatusAdapter extends RecyclerView.Adapter<OrderStatusAdapter.MyViewModel> {
    private Context context;
    private ArrayList<String> orderStatusList;

    public OrderStatusAdapter(Context context, ArrayList<String> orderStatusList) {
        this.context = context;
        this.orderStatusList = orderStatusList;
    }

    @NonNull
    @Override
    public MyViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_status, parent,false);
        return new MyViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewModel holder, int position) {
        String resto_name = orderStatusList.get(position);
        holder.text_status.setText(resto_name);
        // holder.text_shop_desc.setText("Opens at 8pm");
    }

    @Override
    public int getItemCount() {
        return orderStatusList.size();
    }

    public class MyViewModel extends RecyclerView.ViewHolder {
        TextView text_status, text_status_desc;

        public MyViewModel(@NonNull View itemView) {
            super(itemView);
            text_status = itemView.findViewById(R.id.text_status);
            text_status_desc = itemView.findViewById(R.id.text_status_desc);
        }



    }
}

