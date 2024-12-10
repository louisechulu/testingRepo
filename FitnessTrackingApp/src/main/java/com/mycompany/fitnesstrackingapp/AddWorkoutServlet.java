/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.fitnesstrackingapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "AddWorkoutServlet", urlPatterns = {"/WorkoutServlet"})
public class AddWorkoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Add Workout</h1>");
            out.println("<form action='WorkoutServlet' method='post'>");
            out.println("Exercise Type: <input type='text' name='exerciseType' required><br>");
            out.println("Duration (minutes): <input type='number' name='duration' required><br>");
            out.println("Calories Burned: <input type='number' name='calories' required><br>");
            out.println("Date (YYYY-DD-MM): <input type='date' name='date' required><br>");
            out.println("<input type='submit' value='Add Workout'>");
            out.println("</form>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String exerciseType = request.getParameter("exerciseType");
        int duration = Integer.parseInt(request.getParameter("duration"));
        int caloriesBurned = Integer.parseInt(request.getParameter("calories"));
        String dateString = request.getParameter("date");

        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-DD-MM");
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace(); // Handle parsing error
            return; // Exit if parsing fails
        }

        // Get or create the FitnessTracker instance in the session
        HttpSession session = request.getSession();
        FitnessTracker fitnessTracker = (FitnessTracker) session.getAttribute("fitnessTracker");
        if (fitnessTracker == null) {
            fitnessTracker = new FitnessTracker();
            session.setAttribute("fitnessTracker", fitnessTracker);
        }

        // Create and add the workout
        Workout workout = new Workout(exerciseType, duration, caloriesBurned, date);
        fitnessTracker.addWorkout(workout);

        // Redirect to the view workouts page
        response.sendRedirect("viewworkouts.html"); // Redirect to ViewWorkoutsServlet
    }
}