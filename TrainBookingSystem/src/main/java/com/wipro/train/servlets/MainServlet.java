package com.wipro.train.servlets;


import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.wipro.train.bean.TrainReservationBean;
import com.wipro.train.service.Administrator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/MainServlet")

public class MainServlet extends HttpServlet {

    private Administrator admin = new Administrator();
    public String addRecord(HttpServletRequest request) {

        try {
            TrainReservationBean bean = new TrainReservationBean();

            bean.setPassengerName(request.getParameter("passengerName"));
            bean.setTrainNumber(request.getParameter("trainNumber"));
            bean.setSeatNo(request.getParameter("seatNo"));
            bean.setTicketNo(request.getParameter("ticketNo"));
            bean.setRemarks(request.getParameter("remarks"));
            String dateStr = request.getParameter("travelDate");
            Date travelDate = Date.valueOf(dateStr);

            bean.setTravelDate(travelDate);

            return admin.addRecord(bean);

        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
    }
    public TrainReservationBean viewRecord(HttpServletRequest request) {

        try {
            String passengerName = request.getParameter("passengerName");
            Date travelDate = Date.valueOf(request.getParameter("travelDate"));

            return admin.viewRecord(passengerName, travelDate);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<TrainReservationBean> viewAllRecords(HttpServletRequest request) {
        return admin.viewAllRecords();
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String operation = request.getParameter("operation");
        if (operation.equals("newRecord")) {

            String result = addRecord(request);

            if (result.equals("FAIL") || result.equals("ERROR")) {
                response.sendRedirect("error.html");
            } else {
                response.sendRedirect("success.html");
            }
        }
        else if (operation.equals("viewRecord")) {

            TrainReservationBean bean = viewRecord(request);

            if (bean == null) {
                request.setAttribute("message",
                        "No matching records exists! Please try again!");
                request.getRequestDispatcher("displayTrainReservation.jsp")
                        .forward(request, response);
            } else {
                request.setAttribute("trainBean", bean);
                request.getRequestDispatcher("displayTrainReservation.jsp")
                        .forward(request, response);
            }
        }

        else if (operation.equals("viewAllRecords")) {

            List<TrainReservationBean> list = viewAllRecords(request);

            if (list.isEmpty()) {
                request.setAttribute("message", "No records available!");
                request.getRequestDispatcher("displayAllTrainReservations.jsp")
                        .forward(request, response);
            } else {
                request.setAttribute("trainList", list);
                request.getRequestDispatcher("displayAllTrainReservations.jsp")
                        .forward(request, response);
            }
        }
    }
}