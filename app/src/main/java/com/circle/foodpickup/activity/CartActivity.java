package com.circle.foodpickup.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;

import com.circle.foodpickup.R;
import com.circle.foodpickup.adapter.CartAdapter;
import com.circle.foodpickup.adapter.RestoMenuAdapter;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    private RecyclerView recycler_food_items;
    private CartAdapter adapter;
    private ArrayList<String> cartList = new ArrayList<>();
    private Snackbar cartSnackBar;
    private RelativeLayout relative_root;
    private MaterialRadioButton radio_credit, radio_debit, radio_bhim, radio_paytm;
    private MaterialCardView card_credit, card_debit_details, card_bhim, card_paytm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // changing status bar color
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getColor(R.color.colorAccent));
        }

        cartList.add("1 x Chicken Lollipop");
        cartList.add("1 x Chicken 65");
        cartList.add("1 x Chicken Loaded Burger");

        radio_credit = findViewById(R.id.radio_credit);
        card_credit = findViewById(R.id.card_credit);

        radio_debit = findViewById(R.id.radio_debit);
        card_debit_details = findViewById(R.id.card_debit_details);

        radio_bhim = findViewById(R.id.radio_bhim);
        card_bhim = findViewById(R.id.card_bhim);

        radio_paytm = findViewById(R.id.radio_paytm);
        card_paytm = findViewById(R.id.card_paytm);

        radio_credit.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b)
                card_credit.setVisibility(View.VISIBLE);
            else
                card_credit.setVisibility(View.GONE);
        });

        radio_debit.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b)
                card_debit_details.setVisibility(View.VISIBLE);
            else
                card_debit_details.setVisibility(View.GONE);
        });
        radio_bhim.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b)
                card_bhim.setVisibility(View.VISIBLE);
            else
                card_bhim.setVisibility(View.GONE);
        });
        radio_paytm.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b)
                card_paytm.setVisibility(View.VISIBLE);
            else
                card_paytm.setVisibility(View.GONE);
        });

        relative_root = findViewById(R.id.relative_root);
        recycler_food_items = findViewById(R.id.recycler_food_items);
        adapter = new CartAdapter(this, cartList);
        recycler_food_items.setAdapter(adapter);

        cartSnackBar = Snackbar.make(relative_root, "", Snackbar.LENGTH_INDEFINITE);
        cartSnackBar.setBackgroundTint(ContextCompat.getColor(getApplicationContext(), R.color.green));
        cartSnackBar.setText("₹190 | 3 items");
        cartSnackBar.setAction("Place Order", view -> startActivity(new Intent(getApplicationContext(), PlaceOrderActivity.class)));
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
            //  cartSnackBar.dismiss();
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