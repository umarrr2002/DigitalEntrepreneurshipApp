package com.example.digitalentrepreneurshipapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class GoalsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goals, container, false);

        ImageButton imageButton = (ImageButton) view.findViewById(R.id.buttonviewchecklist);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        Fragment fragment = new ChecklistFragment();
                        FragmentTransaction transaction=getFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameLayout,fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
            }
        });
        return view;
    }
}