package com.example.digitalentrepreneurshipapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        frameLayout = findViewById(R.id.frameLayout);

        BottomNavigationView mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
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
                    loadFragment(new WorkoutsFragment(), false);

                } else if (itemId == R.id.navgoalsetting) {
                    loadFragment(new GoalsFragment(), false);

                } else { //nav profile
                    loadFragment(new ProfileFragment(), false);
                }

                return true;
            }
        });

        loadFragment(new WorkoutsFragment(), true); //load fragment when first opened app

        initWidgets();
        CalendarUtils.selectedDate = LocalDate.now();
        //setMonthView();
    }

    //BottomNavigationBar
    public void loadFragment(Fragment fragment, boolean isAppInitialised) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isAppInitialised) {
            fragmentTransaction.add(R.id.frameLayout, fragment);
        } else {
            fragmentTransaction.replace(R.id.frameLayout, fragment);
        }

        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    //Calendar
    private void initWidgets() {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearTVm);
    }
}

//    private void setMonthView()
//    {
//        monthYearText.setText(CalendarUtils.monthYearFromDate(CalendarUtils.selectedDate));
//        ArrayList<LocalDate> daysInMonth = CalendarUtils.daysInMonthArray(CalendarUtils.selectedDate);
//
//        CalendarAdapter calendarAdapter = new CalendarAdapter(daysInMonth, this);
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
//        calendarRecyclerView.setLayoutManager(layoutManager);
//        calendarRecyclerView.setAdapter(calendarAdapter);
//
//        //TODO: Issue with calendar onItemListener. Everything else related to calendar is working fine - needs debugging
//    }

//    @RequiresApi(api = Build.VERSION_CODES.O)
//    public void previousMonthAction(View view)
//    {
//        CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusMonths(1);
//        setMonthView();
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.O)
//    public void nextMonthAction(View view)
//    {
//        CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusMonths(1);
//        setMonthView();
//    }

//    @Override
//    public void onItemClick(int position, LocalDate date)
//    {
//        if(date != null)
//        {
//            CalendarUtils.selectedDate = date;
//            setMonthView();
//        }
//    }

//    public void weeklyAction(View view)
//    {
//        startActivity(new Intent(this, WeekViewActivity.class));
//    }
//}