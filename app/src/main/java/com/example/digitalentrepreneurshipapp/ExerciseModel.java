package com.example.digitalentrepreneurshipapp;

class ExerciseModel {
    String ExerciseTitle;
    String ExerciseMuscleGroup;
    String ExerciseWorkoutStyle;
    String ExerciseEquipment;
    int ExerciseImage;

    public ExerciseModel(String exerciseTitle, String exerciseMuscleGroup, String exerciseWorkoutStyle, String exerciseEquipment, int exerciseImage) {
        ExerciseTitle = exerciseTitle;
        ExerciseMuscleGroup = exerciseMuscleGroup;
        ExerciseWorkoutStyle = exerciseWorkoutStyle;
        ExerciseEquipment = exerciseEquipment;
        ExerciseImage = exerciseImage;
    }

    public String getExerciseTitle() {
        return ExerciseTitle;
    }

    public String getExerciseMuscleGroup() {
        return ExerciseMuscleGroup;
    }

    public String getExerciseWorkoutStyle() {
        return ExerciseWorkoutStyle;
    }

    public String getExerciseEquipment() {
        return ExerciseEquipment;
    }

    public int getExerciseImage() {
        return ExerciseImage;
    }
}
