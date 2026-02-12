<%@ page import="java.util.*, com.wipro.train.bean.TrainReservationBean" %>

<html>
<head>
<title>All Reservations</title>
</head>
<body>

<h2>All Train Reservations</h2>

<%
    List<TrainReservationBean> list =
        (List<TrainReservationBean>) request.getAttribute("trainList");

    if (list == null || list.isEmpty()) {
%>
        <h3>No records available!</h3>
<%
    } else {
%>

<table border="1">
<tr>
    <th>Record ID</th>
    <th>Passenger Name</th>
    <th>Train Number</th>
    <th>Travel Date</th>
    <th>Seat No</th>
    <th>Ticket No</th>
    <th>Remarks</th>
</tr>

<%
    for (TrainReservationBean bean : list) {
%>
<tr>
    <td><%= bean.getRecordId() %></td>
    <td><%= bean.getPassengerName() %></td>
    <td><%= bean.getTrainNumber() %></td>
    <td><%= bean.getTravelDate() %></td>
    <td><%= bean.getSeatNo() %></td>
    <td><%= bean.getTicketNo() %></td>
    <td><%= bean.getRemarks() %></td>
</tr>
<%
    }
%>

</table>

<%
    }
%>

</body>
</html>