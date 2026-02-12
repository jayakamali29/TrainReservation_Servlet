package com.wipro.train.service;

import java.sql.Date;
import java.util.List;

import com.wipro.train.bean.TrainReservationBean;
import com.wipro.train.dao.TrainReservationDAO;
import com.wipro.train.util.InvalidInputException;

public class Administrator {
	public String addRecord(TrainReservationBean trainBean) {
		  TrainReservationDAO dao = new TrainReservationDAO();

		        try {
		            if (trainBean == null ||
		                trainBean.getPassengerName() == null ||
		                trainBean.getTravelDate() == null) {

		                throw new InvalidInputException();
		            }
		            String passengerName = trainBean.getPassengerName();
		            Date travelDate = trainBean.getTravelDate();
		            if (passengerName.length() < 2) {
		                return "INVALID PASSENGER NAME";
		            }
		            Date today = new Date(System.currentTimeMillis());
		            if (travelDate.before(today)) {
		                return "INVALID DATE";
		            }

		            if (dao.recordExists(passengerName, travelDate)) {
		                return "ALREADY EXISTS";
		            }

		            String recordId = dao.generateRecordID(passengerName, travelDate);
		            trainBean.setRecordId(recordId);
		            return dao.createRecord(trainBean);

		        } catch (InvalidInputException e) {
		            return "INVALID INPUT";
		        } catch (Exception e) {
		            e.printStackTrace();
		            return "ERROR";
		        }
		    }
	public TrainReservationBean viewRecord(String passengerName, Date travelDate) {
        TrainReservationDAO dao = new TrainReservationDAO();
        return dao.fetchRecord(passengerName, travelDate);
    }

    public List<TrainReservationBean> viewAllRecords() {
        TrainReservationDAO dao = new TrainReservationDAO();
        return dao.fetchAllRecords();
    }
	
		}