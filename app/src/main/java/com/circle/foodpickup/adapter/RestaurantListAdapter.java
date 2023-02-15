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

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.MyViewModel> {
    private Context context;
    private ArrayList<String> resto_list;

    public RestaurantListAdapter(Context context, ArrayList<String> resto_list) {
        this.context = context;
        this.resto_list = resto_list;
    }

    @NonNull
    @Override
    public MyViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop, parent,false);
        return new MyViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewModel holder, int position) {
        String resto_name = resto_list.get(position);
        holder.text_shop_name.setText(resto_name);
       // holder.text_shop_desc.setText("Opens at 8pm");
    }

    @Override
    public int getItemCount() {
        return resto_list.size();
    }

    public class MyViewModel extends RecyclerView.ViewHolder {
        TextView text_shop_name, text_shop_desc;
        MaterialCardView layout_root;

        public MyViewModel(@NonNull View itemView) {
            super(itemView);
            text_shop_name = itemView.findViewById(R.id.text_shop_name);
            text_shop_desc = itemView.findViewById(R.id.text_shop_desc);
            layout_root = itemView.findViewById(R.id.layout_root);

            layout_root.setOnClickListener(v -> {
                Intent intent = new Intent(context, RestoMenuActivity.class);
                context.startActivity(intent);
            });
        }



    }
}
