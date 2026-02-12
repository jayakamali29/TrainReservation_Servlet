# Train Booking System

A Java-based web application for managing train reservations. This project allows users to add, view, and manage train bookings with a simple and user-friendly web interface. Built using **Java Servlets, JSP, and MySQL**, and deployed on **Apache Tomcat 10**.

---


## Features
- Add new train reservations with details like train number, name, source, destination, and passenger info.  
- View all train reservations in a tabular format.  
- Search and display details of a specific reservation.  
- Simple error handling for invalid inputs.  
- Clean navigation with menu-driven HTML and JSP pages.  

---

## Technology Stack
- **Programming Language:** Java SE 21  
- **Web Technologies:** JSP, HTML, CSS, Servlets  
- **Database:** MySQL  
- **Server:** Apache Tomcat 10  
- **IDE:** Eclipse IDE  

---

## Project Structure
TrainBookingSystem/
├── src/main/java/com/wipro/train
│ ├── bean
│ │ └── TrainReservationBean.java # JavaBean for reservation details
│ ├── dao
│ │ └── TrainReservationDAO.java # Handles DB operations
│ ├── service
│ │ └── Administrator.java # Business logic
│ ├── servlets
│ │ └── MainServlet.java # Handles HTTP requests/responses
│ └── util
│ ├── DBUtil.java # Database connection utility
│ └── InvalidInputException.java # Custom exception for validation
├── webapp
│ ├── META-INF
│ ├── WEB-INF
│ ├── JSP & HTML files
│ │ ├── addTrainReservation.jsp
│ │ ├── displayAllTrainReservations.jsp
│ │ ├── displayTrainReservation.jsp
│ │ ├── viewAllTrainReservations.jsp
│ │ ├── viewTrainReservation.jsp
│ │ ├── menu.html
│ │ ├── success.html
│ │ └── error.html
└── build/

Configure database

Create a MySQL database train_booking

Create a train_reservations table with appropriate fields

Update DBUtil.java with your DB username and password

Run on Apache Tomcat

Configure Tomcat 10 in Eclipse

Right-click the project → Run As → Run on Server

Usage

Open menu.html to navigate the system.

Add a new train reservation via addTrainReservation.jsp.

View all reservations with displayAllTrainReservations.jsp.

Search and view specific reservations with displayTrainReservation.jsp or viewTrainReservation.jsp.

On successful operations, success.html is displayed.

Invalid inputs or errors will redirect to error.html.

<img width="392" height="350" alt="Screenshot 2026-02-12 212306" src="https://github.com/user-attachments/assets/6577fb97-0586-47e9-9348-d74ccc83f5f5" />

<img width="388" height="302" alt="Screenshot 2026-02-12 212427" src="https://github.com/user-attachments/assets/d1579ca1-8b1e-439f-91c7-90a0e7e1c29c" />

<img width="932" height="252" alt="Screenshot 2026-02-12 212453" src="https://github.com/user-attachments/assets/98e7910f-b8ce-4fba-830f-f11ab4369eae" />

Author: Jayakamali V

Email:jayakamali29@gmail.com

GitHub: https://github.com/jayakamali29


