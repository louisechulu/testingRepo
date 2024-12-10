/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitnesstrackingapp;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class Workout {
    private String exerciseType;
    private int duration; // in minutes
    private int caloriesBurned;
    private Date date;

    public Workout(String exerciseType, int duration, int caloriesBurned, Date date) {
        if (duration < 0 || caloriesBurned < 0) {
            throw new IllegalArgumentException("Duration and calories burned must be non-negative.");
        }
        this.exerciseType = exerciseType;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.date = date;
    }

    // Getters
    public String getExerciseType() {
        return exerciseType;
    }

    public int getDuration() {
        return duration;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public Date getDate() {
        return date;
    }

    // Method to get a formatted date in "dd-MM-yyyy"
    public String getFormattedDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }

    // Override equals and hashCode for proper comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Workout workout = (Workout) obj;
        return duration == workout.duration &&
               caloriesBurned == workout.caloriesBurned &&
               exerciseType.equals(workout.exerciseType) &&
               normalizeDate(date).equals(normalizeDate(workout.date));
    }

    @Override
    public int hashCode() {
        return Objects.hash(exerciseType, duration, caloriesBurned, normalizeDate(date));
    }

    private Date normalizeDate(Date date) {
        if (date == null) return null;
        return new Date(date.getYear(), date.getMonth(), date.getDate()); // Normalize to midnight
    }

    // Override toString method for easier representation
    @Override
    public String toString() {
        return "Workout{" +
                "exerciseType='" + exerciseType + '\'' +
                ", duration=" + duration +
                ", caloriesBurned=" + caloriesBurned +
                ", date=" + getFormattedDate() +
                '}';
    }
}