<%-- 
    Document   : viewworkouts
    Created on : Dec 4, 2024, 2:17:46 PM
    Author     : louch
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.fitnesstrackingapp.Workout" %>
<%@ page import="com.mycompany.fitnesstrackingapp.FitnessTracker" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
    // Retrieve the FitnessTracker instance from the session    
    FitnessTracker fitnessTracker = (FitnessTracker) session.getAttribute("fitnessTracker");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Workouts</title>
    <link rel="stylesheet" href="style.css"> <!-- Optional: Include your CSS file -->
</head>
<body>
    <h1>Your Workouts</h1>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="addworkout.jsp">Add Workout</a></li>
            <li><a href="about.html">About</a></li>
        </ul>
    </nav>

    <h2>List of Workouts</h2>
    <form action="SearchWorkoutServlet" method="GET">
        <label for="search">Search by Type:</label>
        <input type="text" id="search" name="exerciseType" placeholder="e.g., Running, Cycling">

        <label for="duration">Search by Duration (minutes):</label>
        <input type="number" id="duration" name="duration" placeholder="e.g., 30">

        <label for="date">Search by Date:</label>
        <input type="date" id="date" name="date">

        <button type="submit">Search</button>
    </form>

    <h3>Workout Details:</h3>
    <%
        // Retrieve the list of workouts from the request attribute
        List<Workout> workouts = (List<Workout>) request.getAttribute("workouts");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

        if (workouts != null && !workouts.isEmpty()) {
            for (Workout workout : workouts) {
    %>
                <div class="workout">
                    Type: <strong><%= workout.getExerciseType() %></strong>, 
                    Duration: <strong><%= workout.getDuration() %> minutes</strong>, 
                    Calories: <strong><%= workout.getCaloriesBurned() %></strong>, 
                    Date: <strong><%= dateFormat.format(workout.getDate()) %></strong>
                </div>
    <%
            }
        } else {
    %>
            <p>No workouts found.</p>
    <%
        }
    %>

    <footer>
        <p>© 2023 Fitness Tracking App</p>
        <a href="index.html">Return to Home</a> <!-- Link to return to the index page -->
    </footer>
</body>
</html>
