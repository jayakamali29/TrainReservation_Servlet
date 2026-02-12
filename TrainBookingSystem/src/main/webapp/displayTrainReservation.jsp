<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.wipro.train.bean.TrainReservationBean" %>

<!DOCTYPE html>
<html>
<head>
    <title>Display Reservation</title>
</head>
<body>

<h2>Train Reservation Details</h2>

<%
    TrainReservationBean bean =
        (TrainReservationBean) request.getAttribute("trainBean");

    String message = (String) request.getAttribute("message");

    if (bean != null) {
%>

Record ID: <%= bean.getRecordId() %><br>
Passenger Name: <%= bean.getPassengerName() %><br>
Train Number: <%= bean.getTrainNumber() %><br>
Travel Date: <%= bean.getTravelDate() %><br>
Seat No: <%= bean.getSeatNo() %><br>
Ticket No: <%= bean.getTicketNo() %><br>
Remarks: <%= bean.getRemarks() %><br>

<%
    } else {
%>

<%= message %>

<%
    }
%>

<br><br>
<a href="menu.html">Back to Menu</a>

</body>
</html>