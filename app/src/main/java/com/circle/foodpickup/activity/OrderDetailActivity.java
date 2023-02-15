package com.circle.foodpickup.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.circle.foodpickup.R;
import com.circle.foodpickup.adapter.CartAdapter;
import com.circle.foodpickup.adapter.OrderItemAdapter;
import com.circle.foodpickup.adapter.OrderStatusAdapter;

import java.util.ArrayList;

public class OrderDetailActivity extends AppCompatActivity {
    private RecyclerView recycler_status, recycler_order_items;
    private OrderStatusAdapter adapter;
    private OrderItemAdapter cart_adapter;
    private ArrayList<String> orderStatusList = new ArrayList<>();
    private ArrayList<String> cartList = new ArrayList<>();
    private ImageView image_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        // changing status bar color
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getColor(R.color.colorAccent));
        }

        orderStatusList.add("Placed");
        orderStatusList.add("Accepted");
        orderStatusList.add("Out for delivery");

        cartList.add("1 x Chicken Lollipop");
        cartList.add("1 x Chicken 65");
        cartList.add("1 x Chicken Loaded Burger");

        image_close = findViewById(R.id.image_close);
        image_close.setOnClickListener(v -> {
            startActivity(new Intent(OrderDetailActivity.this, MainActivity.class));
        });

        recycler_status = findViewById(R.id.recycler_status);
        adapter = new OrderStatusAdapter(this, orderStatusList);
        recycler_status.setAdapter(adapter);

        recycler_order_items = findViewById(R.id.recycler_order_items);
        cart_adapter = new OrderItemAdapter(this, cartList);
        recycler_order_items.setAdapter(cart_adapter);

    }
}