package com.circle.foodpickup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.circle.foodpickup.R;

import java.util.ArrayList;

public class RestoMenuAdapter extends RecyclerView.Adapter<RestoMenuAdapter.MyViewModel> {
    private Context context;
    private ArrayList<String> menuList;

    public RestoMenuAdapter(Context context, ArrayList<String> menuList) {
        this.context = context;
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public MyViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent,false);
        return new MyViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewModel holder, int position) {
        String resto_name = menuList.get(position);
        holder.text_food_name.setText(resto_name);
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class MyViewModel extends RecyclerView.ViewHolder {
        TextView text_food_name;

        public MyViewModel(@NonNull View itemView) {
            super(itemView);
            text_food_name = itemView.findViewById(R.id.text_food_name);
        }
    }
}
