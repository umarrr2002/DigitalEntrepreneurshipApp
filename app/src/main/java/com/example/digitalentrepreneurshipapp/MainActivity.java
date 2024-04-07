package com.example.digitalentrepreneurshipapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        frameLayout = findViewById(R.id.frameLayout);

        BottomNavigationView mBottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomNavigationView);
        mBottomNavigationView.getMenu().findItem(R.id.navworkouts).setChecked(true); //load navigation bar default when first opened app

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.navnutrition) {
                    loadFragment(new NutritionFragment(), false);

                } else if (itemId == R.id.navcalendar) {
                    loadFragment(new CalendarFragment(), false);

                } else if (itemId == R.id.navworkouts) {
                    loadFragment(new WorkoutsFragment(),false);

                } else if (itemId == R.id.navgoalsetting) {
                    loadFragment(new GoalsFragment(),false);

                } else { //nav profile
                    loadFragment(new ProfileFragment(), false);
                }

                return true;
            }
        });

        loadFragment(new WorkoutsFragment(), true); //load fragment when first opened app
    }

    public void loadFragment(Fragment fragment, boolean isAppInitialised) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isAppInitialised){
            fragmentTransaction.add(R.id.frameLayout, fragment);
        } else {
            fragmentTransaction.replace(R.id.frameLayout, fragment);
        }

        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}