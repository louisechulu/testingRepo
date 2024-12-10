/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitnesstrackingapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * FitnessTracker class to manage and sort workouts.
 */
public class FitnessTracker {
    private List<Workout> workouts; // List to store workouts

    public FitnessTracker() {
        workouts = new ArrayList<>();
    }

    /**
     * Adds a workout to the tracker.
     * 
     * @param workout The workout to add.
     */
    public void addWorkout(Workout workout) {
        workouts.add(workout); // Add workout to the list
    }

    /**
     * Returns a copy of the list of workouts.
     * 
     * @return A copy of the workouts list.
     */
    public List<Workout> getWorkouts() {
        return new ArrayList<>(workouts); // Return a copy of the workouts list
    }

    /**
     * Returns a sorted list of workouts based on the specified criteria.
     * 
     * @param criteria The criteria to sort by.
     * @return A sorted list of workouts.
     */
    public List<Workout> getSortedWorkouts(SortingCriteria criteria) {
        List<Workout> sortedWorkouts = new ArrayList<>(workouts);
        switch (criteria) {
            case DURATION:
                Collections.sort(sortedWorkouts, Comparator.comparingInt(Workout::getDuration));
                break;
            case DATE:
                Collections.sort(sortedWorkouts, Comparator.comparing(Workout::getDate));
                break;
        }
        return sortedWorkouts; // Return the sorted list
    }

    List<Workout> getSortedWorkouts() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    List<Workout> sortWorkoutsByDate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Removed unused methods
    // List<Workout> getSortedWorkouts() { ... }
    // List<Workout> sortWorkoutsByDate() { ... }

    /**
     * Enum to define sorting criteria.
     */
    public enum SortingCriteria {
        DURATION,
        DATE
    }

    /**
     * Returns all workouts.
     * 
     * @return A copy of all workouts.
     */
    public List<Workout> getAllWorkouts() {
        return new ArrayList<>(workouts); // Return a copy of the workouts list
    }
}