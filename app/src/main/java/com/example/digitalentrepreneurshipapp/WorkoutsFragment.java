package com.example.digitalentrepreneurshipapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class WorkoutsFragment extends Fragment {

    private ArrayList<Workout> workoutArrayList;
    private String[] workoutName;
    private String[] workoutTargets;
    private String[] workoutTime;
    private int[] imageResourceID;
    private RecyclerView wrecyclerview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workouts, container, false);

        ImageButton imageButton = (ImageButton) view.findViewById(R.id.buttonviewexercises);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ExercisesFragment();
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.buttonmapgyms);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new MapWorkoutsFragment();
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialise();

        wrecyclerview = view.findViewById(R.id.workoutsRecyclerView);
        wrecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        wrecyclerview.setHasFixedSize(true);
        WorkoutAdapter workoutAdapter = new WorkoutAdapter(getContext(), workoutArrayList);
        wrecyclerview.setAdapter(workoutAdapter);

        workoutAdapter.notifyDataSetChanged();
    }

    private void dataInitialise() {

        workoutArrayList = new ArrayList<>();

        workoutName = new String[]{
                getString(R.string.workoutName1),
                getString(R.string.workoutName2),
                getString(R.string.workoutName3),
                getString(R.string.workoutName4),
                getString(R.string.workoutName5),
                getString(R.string.workoutName6),
                getString(R.string.workoutName7),
                getString(R.string.workoutName8),
                getString(R.string.workoutName9),
                getString(R.string.workoutName10),
                getString(R.string.workoutName11),
                getString(R.string.workoutName12)
        };

        workoutTargets = new String[]{
                getString(R.string.workoutTargets1),
                getString(R.string.workoutTargets2),
                getString(R.string.workoutTargets3),
                getString(R.string.workoutTargets4),
                getString(R.string.workoutTargets5),
                getString(R.string.workoutTargets6),
                getString(R.string.workoutTargets7),
                getString(R.string.workoutTargets8),
                getString(R.string.workoutTargets9),
                getString(R.string.workoutTargets10),
                getString(R.string.workoutTargets11),
                getString(R.string.workoutTargets12)
        };

        workoutTime = new String[]{
                getString(R.string.workoutTime1),
                getString(R.string.workoutTime2),
                getString(R.string.workoutTime3),
                getString(R.string.workoutTime4),
                getString(R.string.workoutTime5),
                getString(R.string.workoutTime6),
                getString(R.string.workoutTime7),
                getString(R.string.workoutTime8),
                getString(R.string.workoutTime9),
                getString(R.string.workoutTime10),
                getString(R.string.workoutTime11),
                getString(R.string.workoutTime12)
        };

        imageResourceID = new int[]{
                R.drawable.bmusclemapcroppedchest,
                R.drawable.bmusclemapcroppedquadriceps,
                R.drawable.bmusclemapcroppedshoulders,
                R.drawable.bmusclemapcroppedbiceps,
                R.drawable.bmusclemapcroppedchest,
                R.drawable.bmusclemapcroppedhamstrings,
                R.drawable.bmusclemapcroppedback,
                R.drawable.bmusclemapcroppedobliques,
                R.drawable.bmusclemapcroppedback,
                R.drawable.bmusclemapcroppedglutes,
                R.drawable.bmusclemapcroppedtriceps,
                R.drawable.bmusclemapcroppedback
        };

        for (int i = 0; i < workoutName.length; i++){
            Workout workout = new Workout(workoutName[i], workoutTargets[i], workoutTime[i], imageResourceID[i]);
            workoutArrayList.add(workout);
        }

    }
}