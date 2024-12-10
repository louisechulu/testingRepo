/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitnesstrackingapp;

/**
 *
 * @author louch
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class UserInterface {
    private FitnessTracker fitnessTracker;
    private JTextArea workoutDisplay;
    private JTextField exerciseTypeField;
    private JTextField durationField;
    private JTextField caloriesField;

    public UserInterface(FitnessTracker fitnessTracker) {
        this.fitnessTracker = fitnessTracker;
        createGUI();
    }

    private void createGUI() {
        JFrame frame = new JFrame("Fitness Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2)); // Adjust rows for the sort button

        inputPanel.add(new JLabel("Exercise Type:"));
        exerciseTypeField = new JTextField();
        inputPanel.add(exerciseTypeField);

        inputPanel.add(new JLabel("Duration (min):"));
        durationField = new JTextField();
        inputPanel.add(durationField);

        inputPanel.add(new JLabel("Calories Burned:"));
        caloriesField = new JTextField();
        inputPanel.add(caloriesField);

        // Add Workout Button
        JButton addButton = new JButton("Add Workout");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWorkout();
            }
        });
        inputPanel.add(addButton);

        // Sort Workouts Button
        JButton sortButton = new JButton("Sort Workouts");
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fitnessTracker.sortWorkoutsByDate();
                updateWorkoutDisplay();
            }
        });
        inputPanel.add(sortButton); // Add the sort button to the panel

        frame.add(inputPanel, BorderLayout.NORTH);

        // Display Area
        workoutDisplay = new JTextArea();
        workoutDisplay.setEditable(false);
        frame.add(new JScrollPane(workoutDisplay), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void addWorkout() {
        String exerciseType = exerciseTypeField.getText();
        int duration = Integer.parseInt(durationField.getText());
        int caloriesBurned = Integer.parseInt(caloriesField.getText());
        Date date = new Date(); // Current date

        Workout workout = new Workout(exerciseType, duration, caloriesBurned, date);
        fitnessTracker.addWorkout(workout);
        updateWorkoutDisplay();
    }

    private void updateWorkoutDisplay() {
        workoutDisplay.setText(""); // Clear the display
        for (Workout workout : fitnessTracker.getWorkouts()) {
            workoutDisplay.append("Type: " + workout.getExerciseType() +
                                  " Duration: " + workout.getDuration() +
                                  " min Calories: " + workout.getCaloriesBurned() +
                                  " Date: " + workout.getDate() + "\n");
        }
    }
}
