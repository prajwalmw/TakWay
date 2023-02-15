package com.circle.foodpickup.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.circle.foodpickup.R;
import com.circle.foodpickup.adapter.RestaurantListAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RestaurantListAdapter adapter;
    private ArrayList<String> arrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TextView text_greeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // changing status bar color
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getColor(R.color.colorAccent));
        }

        arrayList.add("Hunger Strike");
        arrayList.add("De Momos Place");
        arrayList.add("Shobha Chinese Point");
        arrayList.add("Red Dragon Food Court");

        recyclerView = findViewById(R.id.recycler_shops);
        text_greeting = findViewById(R.id.text_greeting);
        text_greeting.setText("Good Morning! \n Prajwal");
        adapter = new RestaurantListAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);
    }
}