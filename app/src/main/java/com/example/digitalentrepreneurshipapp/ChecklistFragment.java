package com.example.digitalentrepreneurshipapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ChecklistFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checklist, container, false);

        ImageButton button = (ImageButton) view.findViewById(R.id.buttonbackchecklisttogoals);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new GoalsFragment();
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.FABaddItemToChecklist);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new AddItemToChecklistFragment();
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}