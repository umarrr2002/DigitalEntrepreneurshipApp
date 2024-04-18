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

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.MyViewHolder> {

    Context context;
    ArrayList<Workout> workoutArrayList;

    public WorkoutAdapter(Context context, ArrayList<Workout> workoutArrayList) {
        this.context = context;
        this.workoutArrayList = workoutArrayList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView titleImage;
        TextView tvHeading;
        TextView tvTime;
        TextView tvTargets;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleImage = itemView.findViewById(R.id.title_image);
            tvHeading = itemView.findViewById(R.id.tvHeading);
            tvTargets = itemView.findViewById(R.id.tvTargets);
            tvTime = itemView.findViewById(R.id.tvTime);
        }
    }

    @NonNull
    @Override
    public WorkoutAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.workouts_list_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutAdapter.MyViewHolder holder, int position) {
        Workout workout = workoutArrayList.get(position);
        holder.tvHeading.setText(workout.heading);
        holder.tvTargets.setText(workout.targets);
        holder.tvTime.setText(workout.time);
        holder.titleImage.setImageResource(workout.titleImage);
    }

    @Override
    public int getItemCount() {
        return workoutArrayList.size();
    }
}