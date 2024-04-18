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

public class ExerciseRecyclerViewAdapter extends RecyclerView.Adapter<ExerciseRecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<ExerciseModel> exerciseModels;

// TODO: Not working, issue with context. Was working in isolated test application with main activity
//
//    public ExerciseRecyclerViewAdapter(ExercisesFragment context, ArrayList<ExerciseModel> exerciseModels){
//        this.context = context;
//        this.exerciseModels = exerciseModels;
//    }

    @NonNull
    @Override
    public ExerciseRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate layout - give look to rows
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.exercise_item_row, parent, false);
        return new ExerciseRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseRecyclerViewAdapter.MyViewHolder holder, int position) {
        //assigning values to rows - based on position of rows

        holder.imageView.setImageResource(exerciseModels.get(position).getExerciseImage());
        holder.tvTitle.setText(exerciseModels.get(position).getExerciseTitle());
        holder.tvMuscleGroup.setText(exerciseModels.get(position).getExerciseMuscleGroup());
        holder.tvWorkoutStyle.setText(exerciseModels.get(position).getExerciseWorkoutStyle());
        holder.tvEquipment.setText(exerciseModels.get(position).getExerciseEquipment());
    }

    @Override
    public int getItemCount() {
        return exerciseModels.size();
        //number of items displayed
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //gets the view from recycler_view_row layout file

        ImageView imageView;
        TextView tvTitle, tvMuscleGroup, tvWorkoutStyle, tvEquipment;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.exerciseImageView);
            tvTitle = itemView.findViewById(R.id.exerciseTitleTextView);
            tvMuscleGroup = itemView.findViewById(R.id.exerciseMuscleGroupTextView);
            tvWorkoutStyle = itemView.findViewById(R.id.exerciseWorkoutStyleTextView);
            tvEquipment = itemView.findViewById(R.id.exerciseEquipmentTextView);
        }
    }
}
