<%-- 
    Document   : addworkout
    Created on : Dec 4, 2024, 2:18:13 PM
    Author     : louch
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Workout</title>
    <link rel="stylesheet" type="text/css" href="style.css"> <!-- Link to your CSS -->
</head>
<body>
    <header>
        <h1>Add a New Workout</h1>
        <nav>
            <a href="index.html">Home</a>
            <a href="viewworkouts.html">View Workouts</a>
            <a href="about.html">About</a>
        </nav>
    </header>

    <main>
        <h2>Workout Form</h2>
        <form action="WorkoutServlet" method="POST">
            <label for="exerciseType">Exercise Type:</label>
            <input type="text" id="exerciseType" name="exerciseType" required>

            <label for="duration">Duration (minutes):</label>
            <input type="number" id="duration" name="duration" required>

            <label for="calories">Calories:</label>
            <input type="number" id="calories" name="calories" required>

            <label for="date">Date:</label>
            <input type="date" id="date" name="date" required>

            <button type="submit">Add Workout</button>
        </form>
    </main>

    <footer>
        <p>© 2023 Fitness Tracking App</p>
    </footer>
</body>
</html>
