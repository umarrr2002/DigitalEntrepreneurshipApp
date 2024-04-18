package com.example.digitalentrepreneurshipapp;

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
import android.widget.ImageButton;

import java.util.ArrayList;

public class FriendsFragment extends Fragment {

    private ArrayList<Friend> friendArrayList;
    private String[] friendName;
    private String[] friendScore;
    private int[] imageResourceID;
    private RecyclerView frecyclerview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);

        ImageButton imageButton = (ImageButton) view.findViewById(R.id.buttonbackfriendstoprofile);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ProfileFragment();
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

        frecyclerview = view.findViewById(R.id.friendsRecyclerView);
        frecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        frecyclerview.setHasFixedSize(true);
        FriendAdapter friendAdapter = new FriendAdapter(getContext(), friendArrayList);
        frecyclerview.setAdapter(friendAdapter);

        friendAdapter.notifyDataSetChanged();
    }

    private void dataInitialise() {

        friendArrayList = new ArrayList<>();

        friendName = new String[]{
                getString(R.string.friendName1),
                getString(R.string.friendName2),
                getString(R.string.friendName3),
                getString(R.string.friendName4),
                getString(R.string.friendName5),
                getString(R.string.friendName6),
                getString(R.string.friendName7),
                getString(R.string.friendName8),
                getString(R.string.friendName9),
                getString(R.string.friendName10),
                getString(R.string.friendName11),
                getString(R.string.friendName12),
                getString(R.string.friendName13),
                getString(R.string.friendName14),
                getString(R.string.friendName15),
                getString(R.string.friendName16)
        };

        friendScore = new String[]{
                getString(R.string.friendScore1),
                getString(R.string.friendScore2),
                getString(R.string.friendScore3),
                getString(R.string.friendScore4),
                getString(R.string.friendScore5),
                getString(R.string.friendScore6),
                getString(R.string.friendScore7),
                getString(R.string.friendScore8),
                getString(R.string.friendScore9),
                getString(R.string.friendScore10),
                getString(R.string.friendScore11),
                getString(R.string.friendScore12),
                getString(R.string.friendScore13),
                getString(R.string.friendScore14),
                getString(R.string.friendScore15),
                getString(R.string.friendScore16)
        };

        imageResourceID = new int[]{
                R.drawable.friendsliamholdsworth,
                R.drawable.friendsbendurkin,
                R.drawable.friendssaraakhan,
                R.drawable.friendsalexgarcia,
                R.drawable.friendsmeganharrison,
                R.drawable.friendsaaronbrown,
                R.drawable.friendsadillonchudasama,
                R.drawable.friendsalucasbroadbent,
                R.drawable.friendshalimawasim,
                R.drawable.friendsaiseemmanuel,
                R.drawable.friendssamanthaevans,
                R.drawable.friendsjoshuaclark,
                R.drawable.friendsnoahwilson,
                R.drawable.friendskatepatel,
                R.drawable.friendsleenicholls,
                R.drawable.friendsannawalker
        };

        for (int i = 0; i < friendName.length; i++){
            Friend friend = new Friend(friendName[i], friendScore[i], imageResourceID[i]);
            friendArrayList.add(friend);
        }

    }
}