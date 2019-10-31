package com.qzy.vendor;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.qzy.vendor.ui.Menu.MenuFragment;
import com.qzy.vendor.ui.Orders.OrdersFragment;
import com.qzy.vendor.ui.Performance.PerformanceFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";
    OrdersFragment orders;
    PerformanceFragment performance;
    MenuFragment menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate:");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();

        if(findViewById(R.id.main_frame_layout) != null){
            //if we are being restored from a previous state. we don't need to do anything
            //or else we will end up with overlapping fragments
            if(savedInstanceState != null) {
                Log.d(TAG, "onCreate: fragment has saved state");
                return;
            }
            //create and attach our fragment
            orders = new OrdersFragment();
            orders.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_frame_layout,orders).commit();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.navigation_orders:
                fragment = new OrdersFragment();
                break;
            case R.id.navigation_menu:
                fragment = new MenuFragment();
                break;
            case R.id.navigation_performance:
                fragment = new PerformanceFragment();
                break;
        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            Log.d(TAG, "loadFragment: switching fragment");
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_frame_layout, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
