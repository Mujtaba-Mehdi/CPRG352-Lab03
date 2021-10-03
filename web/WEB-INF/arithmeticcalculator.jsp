<%-- 
    Document   : arithmeticcalculator
    Created on : 2-Oct-2021, 11:55:08 AM
    Author     : mujtaba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="POST" action="arithmetic">
            <label>First:</label>
            <input type="text" name="first" value="${first}">
            <br>
            <label>Second:</label>
            <input type="text" name="second" value="${second}">
            <br>           
            <input type="submit" name="add" value="+">
            <input type="submit" name="subtract" value="-">
            <input type="submit" name="multiply" value="*">    
            <input type="submit" name="divide" value="%">
        </form>
            <p>Result: ${messagetwo}</p>    
            <a href="age">Age Calculator</a>
    </body>
</html>
