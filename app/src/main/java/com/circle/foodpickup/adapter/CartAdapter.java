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

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewModel> {
    private Context context;
    private ArrayList<String> cartList;

    public CartAdapter(Context context, ArrayList<String> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartAdapter.MyViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart_product, parent,false);
        return new CartAdapter.MyViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.MyViewModel holder, int position) {
        String food_name = cartList.get(position);
        holder.text_food_name.setText(food_name);
        holder.text_food_price.setText("₹50");
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class MyViewModel extends RecyclerView.ViewHolder {
        private TextView text_food_name;
        private TextView text_food_price;

        public MyViewModel(@NonNull View itemView) {
            super(itemView);
            text_food_name = itemView.findViewById(R.id.text_food_name);
            text_food_price = itemView.findViewById(R.id.text_food_price);
        }
    }
}
