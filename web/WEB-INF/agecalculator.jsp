<%-- 
    Document   : agecalculator
    Created on : 23-Sep-2021, 12:05:03 PM
    Author     : mujtaba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form method="POST" action="age">
            <label>Enter your age:</label>
            <input type="text" name="age" value="${age}">
            <br>
            <input type="submit" value="Age Next Birthday">
        </form>
        <p>${error}</p>
    </body>
</html>
