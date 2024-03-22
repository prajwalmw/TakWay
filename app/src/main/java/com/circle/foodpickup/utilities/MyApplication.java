package com.circle.foodpickup.utilities;

import android.app.Application;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by - Prajwal W. on 22/03/24.
 * Email: prajwalwaingankar@gmail.com
 * Mobile: +917304154312
 **/
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
