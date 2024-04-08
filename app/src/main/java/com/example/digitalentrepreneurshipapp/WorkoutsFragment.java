package com.example.digitalentrepreneurshipapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WorkoutsFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_workouts, container, false);

            FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.FABviewExercises);
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragment = new ExercisesFragment();
                    FragmentTransaction transaction=getFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayout,fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });
            return view;
        }
    }