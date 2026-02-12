<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>View Train Reservation</title>
</head>
<body>

<h2>View Train Reservation</h2>

<form action="MainServlet" method="post">

    <input type="hidden" name="operation" value="viewRecord">

    Passenger Name: <input type="text" name="passengerName"><br><br>
    Travel Date (yyyy-mm-dd): <input type="date" name="travelDate"><br><br>

    <input type="submit" value="View Reservation">

</form>

</body>
</html>