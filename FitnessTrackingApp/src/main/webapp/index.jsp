<%-- 
    Document   : index
    Created on : Dec 4, 2024, 2:18:36 PM
    Author     : louch
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Fitness Tracking App</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"> <!-- Link to your CSS file -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 20px;
        }

        header {
            background-color: #4CAF50;
            color: white;
            padding: 10px 0;
            text-align: center;
        }

        nav {
            margin: 20px 0;
        }

        nav a {
            margin: 0 15px;
            color: #4CAF50;
            text-decoration: none;
            font-weight: bold;
        }

        nav a:hover {
            text-decoration: underline;
        }

        main {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        footer {
            text-align: center;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            position: relative;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to the Fitness Tracking App</h1>
    </header>

    <nav>
        <a href="addworkout.jsp">Add Workout</a>
        <a href="viewworkouts.jsp">View Workouts</a>
        <a href="about.jsp">About</a>
    </nav>

    <main>
        <h2>Track Your Fitness</h2>
        <p>Welcome to the Fitness Tracking App, where you can log your workouts, monitor your progress, and stay motivated to reach your fitness goals.</p>
        <p>Use the navigation links above to get started!</p>
    </main>

    <footer>
        <p>&copy; 2023 Fitness Tracking App</p>
    </footer>
</body>
</html>
 