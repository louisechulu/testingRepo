/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.fitnesstrackingapp;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@WebServlet(name = "ViewWorkoutsServlet", urlPatterns = {"/viewworkouts"})
public class ViewWorkoutsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        FitnessTracker fitnessTracker = (FitnessTracker) session.getAttribute("fitnessTracker");

        PrintWriter out = response.getWriter();
        out.println("<h1>Your Workouts</h1>");

        if (fitnessTracker == null || fitnessTracker.getWorkouts().isEmpty()) {
            out.println("<p>No workouts found.</p>");
        } else {
            List<Workout> sortedWorkouts = fitnessTracker.getSortedWorkouts(); // Get sorted workouts
            for (Workout workout : sortedWorkouts) {
                out.println("<div class='workout'>");
                out.println("<strong>Type:</strong> " + workout.getExerciseType() + "<br>");
                out.println("<strong>Duration:</strong> " + workout.getDuration() + " minutes<br>");
                out.println("<strong>Calories Burned:</strong> " + workout.getCaloriesBurned() + "<br>");
                out.println("<strong>Date:</strong> " + workout.getDate() + "<br>");
                out.println("</div><br>");
            }
        }
        out.println("<br><a href='addworkout.jsp'>Add another workout</a>");
    }
}