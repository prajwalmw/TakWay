package com.circle.foodpickup.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.circle.foodpickup.R;

public class PlaceOrderActivity extends AppCompatActivity {
    private LottieAnimationView animationView;
    private TextView text_go_home, text_view_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        // changing status bar color
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getColor(R.color.white));
        }

        animationView = findViewById(R.id.animation_view);
        text_go_home = findViewById(R.id.text_go_home);
        text_view_order = findViewById(R.id.text_view_order);

        animationView.loop(false);
        animationView.setAnimation("order_success_animation.json");
        animationView.playAnimation();

        text_view_order.setOnClickListener(v -> {
            startActivity(new Intent(PlaceOrderActivity.this, OrderDetailActivity.class));
        });

        text_go_home.setOnClickListener(v -> {
            startActivity(new Intent(PlaceOrderActivity.this, MainActivity.class));
        });
    }
}