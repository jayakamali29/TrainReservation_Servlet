<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Train Reservation</title>
</head>
<body>

<h2>Add Train Reservation</h2>

<form action="MainServlet" method="post">

    <input type="hidden" name="operation" value="newRecord">

    Passenger Name: <input type="text" name="passengerName"><br><br>
    Train Number: <input type="text" name="trainNumber"><br><br>
    Travel Date (yyyy-mm-dd): <input type="date" name="travelDate"><br><br>
    Seat No: <input type="text" name="seatNo"><br><br>
    Ticket No: <input type="text" name="ticketNo"><br><br>
    Remarks: <input type="text" name="remarks"><br><br>

    <input type="submit" value="Add Reservation">

</form>

</body>
</html>