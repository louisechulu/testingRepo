/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitnesstrackingapp;

/**
 *
 * @author louch
 */


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

import static org.testng.Assert.*;

public class FitnessTrackerTest {
    private FitnessTracker fitnessTracker;

    @BeforeMethod
    public void setUp() {
        fitnessTracker = new FitnessTracker();
    }

    @Test
    public void testAddWorkout() {
        Date workoutDate = new Date();
        Workout workout = new Workout("Running", 30, 300, workoutDate);
        fitnessTracker.addWorkout(workout);

        assertEquals(fitnessTracker.getWorkouts().size(), 1);
        assertEquals(fitnessTracker.getWorkouts().get(0), workout);
    }

    @Test
    public void testGetSortedWorkouts() {
        Date workoutDate = new Date();
        Workout workout1 = new Workout("Cycling", 45, 400, workoutDate);
        Workout workout2 = new Workout("Swimming", 20, 200, workoutDate);
        Workout workout3 = new Workout("Running", 30, 300, workoutDate);

        fitnessTracker.addWorkout(workout1);
        fitnessTracker.addWorkout(workout2);
        fitnessTracker.addWorkout(workout3);

        // Test sorted workouts by duration
        List<Workout> sortedWorkouts = fitnessTracker.getSortedWorkouts();
        assertEquals(sortedWorkouts.get(0), workout2); // Swimming (20 mins)
        assertEquals(sortedWorkouts.get(1), workout3); // Running (30 mins)
        assertEquals(sortedWorkouts.get(2), workout1); // Cycling (45 mins)
    }

    @Test
    public void testSortWorkoutsByDate() {
        Date workoutDate1 = new Date();
        Date workoutDate2 = new Date(workoutDate1.getTime() + 1000 * 60 * 60 * 24); // 1 day later
        Workout workout1 = new Workout("Running", 30, 300, workoutDate1);
        Workout workout2 = new Workout("Cycling", 45, 400, workoutDate2);

        fitnessTracker.addWorkout(workout2);
        fitnessTracker.addWorkout(workout1);

        // Test sorting by date
        List<Workout> sortedByDate = fitnessTracker.sortWorkoutsByDate();
        assertEquals(sortedByDate.get(0), workout1); // Running should come first
        assertEquals(sortedByDate.get(1), workout2); // Cycling should come second
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidWorkoutDuration() {
        new Workout("Running", -30, 300, new Date()); // should throw exception
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidCaloriesBurned() {
        new Workout("Running", 30, -300, new Date()); // should throw exception
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testEmptyExerciseType() {
        new Workout("", 30, 300, new Date()); // should throw exception
    }
}