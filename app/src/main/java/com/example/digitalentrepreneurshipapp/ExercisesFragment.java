package com.example.digitalentrepreneurshipapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;

public class ExercisesFragment extends Fragment {

    ArrayList<ExerciseModel> exerciseModels = new ArrayList<>();

    int[] exerciseImages = {R.drawable.bmusclemapcroppedchest, R.drawable.bmusclemapcroppedback, R.drawable.bmusclemapcroppedquadriceps,
            R.drawable.bmusclemapcroppedbiceps, R.drawable.bmusclemapcroppedback, R.drawable.bmusclemapcroppedtriceps,
            R.drawable.bmusclemapcroppedhamstrings, R.drawable.bmusclemapcroppedquadriceps, R.drawable.bmusclemapcroppedchest,
            R.drawable.bmusclemapcroppedback, R.drawable.bmusclemapcroppedshoulders};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercises, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.exercisesRecyclerView);

        setupExerciseModels();


// TODO: Not working, issue with context. Was working in isolated test application with main activity
//
//        ExerciseRecyclerViewAdapter adapter = new ExerciseRecyclerViewAdapter(this, exerciseModels);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageButton button = (ImageButton) view.findViewById(R.id.buttonbackexercisestoworkouts);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new WorkoutsFragment();
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }

    private void setupExerciseModels(){
        String[] exerciseTitles = getResources().getStringArray(R.array.exercise_title_txt);
        String[] exerciseMuscleGroups = getResources().getStringArray(R.array.exercise_musclegroup_txt);
        String[] exerciseWorkoutStyle = getResources().getStringArray(R.array.exercise_workoutstyle_txt);
        String[] exerciseEquipment = getResources().getStringArray(R.array.exercise_equipment_txt);

        for (int i = 0; i<exerciseTitles.length; i++){
            exerciseModels.add(new ExerciseModel(
                    exerciseTitles[i],
                    exerciseMuscleGroups[i],
                    exerciseWorkoutStyle[i],
                    exerciseEquipment[i],
                    exerciseImages[i]));
        };
    }
}