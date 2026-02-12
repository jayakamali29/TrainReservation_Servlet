package com.wipro.train.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.wipro.train.bean.TrainReservationBean;
import com.wipro.train.util.DBUtil;

public class TrainReservationDAO {
     public String createRecord(TrainReservationBean trainBean)
     {
    	 try {
    		 Connection con=DBUtil.getDBConnection();
    		 PreparedStatement ps=con.prepareStatement("insert into TRAINERS_TB values(?,?,?,?,?,?,?)");
    		 		ps.setString(1,trainBean.getRecordId());
    		 		ps.setString(2, trainBean.getPassengerName());
    		 		ps.setString(3, trainBean.getTrainNumber());
    		 		ps.setDate(4, trainBean.getTravelDate());
    		 		ps.setString(5, trainBean.getSeatNo());
    		 		ps.setString(6, trainBean.getTicketNo());
    		 		ps.setString(7, trainBean.getRemarks());
    		 		int rows = ps.executeUpdate();

    		        if (rows > 0)
    		            return "SUCCESS";
    		        else
    		            return "FAIL";
    	 } catch (Exception e) {
             e.printStackTrace();
             return "ERROR";
         }
 
    		 		
    		 
    	 }
     public TrainReservationBean fetchRecord(String passengerName, Date travelDate) {

    	    TrainReservationBean bean = null;

    	    try (Connection con = DBUtil.getDBConnection();
    	         PreparedStatement ps = con.prepareStatement(
    	             "SELECT * FROM TRAINERS_TB WHERE UPPER(PASSENGERNAME)=UPPER(?) AND TRUNC(TRAVELDATE)=TRUNC(?)")) {

    	        ps.setString(1, passengerName);
    	        ps.setDate(2, travelDate);

    	        ResultSet rs = ps.executeQuery();

    	        if (rs.next()) {
    	            bean = new TrainReservationBean();
    	            bean.setRecordId(rs.getString(1));
    	            bean.setPassengerName(rs.getString(2));
    	            bean.setTrainNumber(rs.getString(3));
    	            bean.setTravelDate(rs.getDate(4));
    	            bean.setSeatNo(rs.getString(5));
    	            bean.setTicketNo(rs.getString(6));
    	            bean.setRemarks(rs.getString(7));
    	        }

    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }

    	    return bean;   
    	}

     public String generateRecordID(String passengerName, Date travelDate) {

    	    String recordId = null;

    	    try (Connection con = DBUtil.getDBConnection();
    	         PreparedStatement ps = con.prepareStatement(
    	             "SELECT COUNT(*) FROM TRAINERS_TB WHERE TRAVELDATE=?")) {
    	        DateFormat format = new SimpleDateFormat("yyyyMMdd");
    	        String datePart = format.format(travelDate);
    	        String namePart;
    	        if (passengerName.length() >= 2) {
    	            namePart = passengerName.substring(0, 2).toUpperCase();
    	        } else {
    	            namePart = passengerName.toUpperCase();
    	        }
    	        ps.setDate(1, travelDate);

    	        ResultSet rs = ps.executeQuery();

    	        int sequence = 1;

    	        if (rs.next()) {
    	            sequence = rs.getInt(1) + 1;
    	        }

    	        String seqPart = String.format("%02d", sequence);

    	        recordId = datePart + namePart + seqPart;

    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }

    	    return recordId;
    	}
     public boolean recordExists(String passengerName, Date travelDate) {

    	    boolean exists = false;

    	    try (Connection con = DBUtil.getDBConnection();
    	         PreparedStatement ps = con.prepareStatement(
    	             "SELECT 1 FROM TRAINERS_TB WHERE UPPER(PASSENGERNAME)=UPPER(?) AND TRUNC(TRAVELDATE)=TRUNC(?)")) {

    	        ps.setString(1, passengerName);
    	        ps.setDate(2, travelDate);

    	        ResultSet rs = ps.executeQuery();

    	        if (rs.next()) {
    	            exists = true;
    	        }

    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }

    	    return exists;
    	}

     public List<TrainReservationBean> fetchAllRecords() {

    	    List<TrainReservationBean> list = new ArrayList<>();

    	    try (Connection con = DBUtil.getDBConnection();
    	         PreparedStatement ps = con.prepareStatement(
    	             "SELECT * FROM TRAINERS_TB");
    	         ResultSet rs = ps.executeQuery()) {

    	        while (rs.next()) {

    	            TrainReservationBean bean = new TrainReservationBean();

    	            bean.setRecordId(rs.getString(1));
    	            bean.setPassengerName(rs.getString(2));
    	            bean.setTrainNumber(rs.getString(3));
    	            bean.setTravelDate(rs.getDate(4));
    	            bean.setSeatNo(rs.getString(5));
    	            bean.setTicketNo(rs.getString(6));
    	            bean.setRemarks(rs.getString(7));

    	            list.add(bean);
    	        }

    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }

    	    return list;   
    	}



     }