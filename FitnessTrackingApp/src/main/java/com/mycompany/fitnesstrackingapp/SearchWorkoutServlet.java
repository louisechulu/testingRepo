package com.mycompany.fitnesstrackingapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "SearchWorkoutServlet", urlPatterns = {"/SearchWorkoutServlet"})
public class SearchWorkoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String exerciseType = request.getParameter("exerciseType");
        String durationParam = request.getParameter("duration");
        String dateParam = request.getParameter("date");

        HttpSession session = request.getSession();
        FitnessTracker fitnessTracker = (FitnessTracker) session.getAttribute("fitnessTracker");

        if (fitnessTracker != null) {
            List<Workout> allWorkouts = fitnessTracker.getAllWorkouts();
            Date filterDate = parseDate(dateParam);

            List<Workout> filteredWorkouts = allWorkouts.stream()
                .filter(workout -> 
                    (exerciseType == null || exerciseType.isEmpty() || workout.getExerciseType().equalsIgnoreCase(exerciseType)) &&
                    (durationParam == null || durationParam.isEmpty() || 
                        (isInteger(durationParam) && workout.getDuration() == Integer.parseInt(durationParam))) &&
                    (filterDate == null || datesEqual(normalizeDate(workout.getDate()), normalizeDate(filterDate))) // Normalize for comparison
                )
                .collect(Collectors.toList());

            request.setAttribute("workouts", filteredWorkouts);
        }

        // Forward to the JSP page
        request.getRequestDispatcher("viewworkouts.jsp").forward(request, response);
    }

    private Date parseDate(String dateParam) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        try {
            return dateFormat.parse(dateParam);
        } catch (ParseException e) {
            return null; // Return null if parsing fails
        }
    }

    private Date normalizeDate(Date date) {
        if (date == null) return null;
        return new Date(date.getYear(), date.getMonth(), date.getDate()); // Normalize to midnight
    }

    private boolean datesEqual(Date date1, Date date2) {
        if (date1 == null || date2 == null) return false;
        return normalizeDate(date1).equals(normalizeDate(date2));
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}