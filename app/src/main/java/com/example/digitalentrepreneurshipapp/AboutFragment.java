package com.example.digitalentrepreneurshipapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class AboutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

    ImageButton button = (ImageButton) view.findViewById(R.id.buttonbackabouttosettings);
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = new SettingsFragment();
            FragmentTransaction transaction=getFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout,fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    });
        return view;
}}