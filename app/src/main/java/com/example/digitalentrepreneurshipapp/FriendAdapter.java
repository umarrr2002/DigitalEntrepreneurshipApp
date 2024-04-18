package com.example.digitalentrepreneurshipapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.MyViewHolder> {

    Context context;
    ArrayList<Friend> friendsArrayList;

    public FriendAdapter(Context context, ArrayList<Friend> friendsArrayList) {
        this.context = context;
        this.friendsArrayList = friendsArrayList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView titleImage;
        TextView tvName;
        TextView tvScore;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleImage = itemView.findViewById(R.id.title_image);
            tvName = itemView.findViewById(R.id.tvHeading);
            tvScore = itemView.findViewById(R.id.tvScore);
        }
    }

    @NonNull
    @Override
    public FriendAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.friends_list_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendAdapter.MyViewHolder holder, int position) {
        Friend friend = friendsArrayList.get(position);
        holder.tvName.setText(friend.name);
        holder.tvScore.setText(friend.score);
        holder.titleImage.setImageResource(friend.titleImage);
    }

    @Override
    public int getItemCount() {
        return friendsArrayList.size();
    }
}