package com.circle.foodpickup.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.circle.foodpickup.R;
import com.circle.foodpickup.adapter.RestoMenuAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class RestoMenuActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RestoMenuAdapter adapter;
    private ArrayList<String> cartList = new ArrayList<>();
    private Snackbar cartSnackBar;
    private RelativeLayout relative_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto_menu);

        // changing status bar color
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getColor(R.color.colorAccent));
        }

        cartList.add("Chicken Lollipop");
        cartList.add("Chicken 65");
        cartList.add("Chicken Loaded Burger");
        cartList.add("Spicy Momos");
        cartList.add("Paneer Chilly");
        cartList.add("Cheesy Pizza");
        cartList.add("Sweet Donut");

        relative_root = findViewById(R.id.relative_root);
        recyclerView = findViewById(R.id.recycler_food_items);
        adapter = new RestoMenuAdapter(this, cartList);
        recyclerView.setAdapter(adapter);

        cartSnackBar = Snackbar.make(relative_root, "", Snackbar.LENGTH_INDEFINITE);
        cartSnackBar.setBackgroundTint(ContextCompat.getColor(getApplicationContext(), R.color.green));
        cartSnackBar.setText("₹200 | 1 item");
        cartSnackBar.setAction("View Cart", view -> startActivity(new Intent(getApplicationContext(), CartActivity.class)));
        updateCartUI();
    }

    private void updateCartUI() {
        int total = 0;
        int totalItems = 0;

        if (cartList.size() > 0) {
          /*  for (i in cartList.indices) {
                total += cartList[i].price * cartList[i].quantity
                totalItems += 1
            }
            if (totalItems == 1) {
                cartSnackBar.setText("₹$total | $totalItems item")
            } else {
                cartSnackBar.setText("₹$total | $totalItems items")
            }

            if (shop?.configurationModel?.isOrderTaken == 1)*/
            cartSnackBar.show();
        } else {
           // preferencesHelper.clearCartPreferences()
            cartSnackBar.dismiss();
        }

     /*   if (shop?.configurationModel?.isOrderTaken == 1) {
            if (shop?.configurationModel?.isDeliveryAvailable == 1) {
                //supportActionBar?.subtitle = "Open now"
                //binding.textPickupOnly.visibility = View.GONE
                closedSnackBar.dismiss()
            } else {
                //binding.textPickupOnly.text = "Pick up only"
                //binding.textPickupOnly.visibility = View.VISIBLE
            }
        }
        else {
            cartSnackBar.dismiss()
            closedSnackBar.setText("Not taking orders")
            closedSnackBar.duration = Snackbar.LENGTH_LONG
            closedSnackBar.show()
            //binding.textPickupOnly.text = "Not taking orders"
            //binding.textPickupOnly.visibility = View.VISIBLE
        }*/
    }

}