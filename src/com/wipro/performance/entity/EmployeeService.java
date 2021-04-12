package com.wipro.performance.entity;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import com.wipro.performance.bean.EmployeeBean;
import com.wipro.performance.exception.InvalidADIDException;
import com.wipro.performance.exception.InvalidBUException;
import com.wipro.performance.exception.InvalidCurrentSalaryException;
import com.wipro.performance.exception.InvalidDOJException;

public class EmployeeService {
	
	int count=0;
	String result="";
	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
	
	double newSalary,ratingSalary,finalSalary,updatedAttendance;
	public String validateData(EmployeeBean eBean) 
			throws InvalidADIDException, InvalidBUException, InvalidDOJException, InvalidCurrentSalaryException {
		
		try {
		if(eBean.getADID().length()==6) 
			count++;
		else
			throw new InvalidADIDException();
		
		if((eBean.getBusinessUnit().equalsIgnoreCase("JAVA")) ||
				(eBean.getBusinessUnit().equalsIgnoreCase("Big Data")) || 
				(eBean.getBusinessUnit().equalsIgnoreCase("Oracle")))
			count++;
		else
			throw new InvalidBUException();
		
		if(eBean.getDateOfJoining().getDate()<date.getDate())
			count++;
		else
			throw new InvalidDOJException();
			
		if(eBean.getCurrentSalary()>50000)
			count++;
		else
			throw new InvalidCurrentSalaryException();
		
		if(eBean.getTotalAttendance()>=0 && eBean.getTotalAttendance()<=200)
			count++;
		else
			System.out.println("INVALID ATTENDANCE");
		
		if(eBean.getManagerRating()>=0 && eBean.getManagerRating()<=5)
			count++;
		else
			System.out.println("INVALID RATING");
		
		}finally {
			if(count==6)
				result="SUCCESS";
			else
				result="FAILURE";	
		}
		return result;
	}
	
	public String computeAppraisal(EmployeeBean eBean) throws InvalidADIDException, InvalidBUException, InvalidDOJException, InvalidCurrentSalaryException {
		
			validateData(eBean);
			
			if(result.equals("SUCCESS")) {
				updatedAttendance=eBean.getTotalAttendance();
				
				if(updatedAttendance>=0 && updatedAttendance<=100) 
					newSalary=eBean.getCurrentSalary();
				else if(updatedAttendance>=101 && updatedAttendance<=150) 
					newSalary=0.05*eBean.getCurrentSalary();
				else if(updatedAttendance>=151 && updatedAttendance<=200)
					newSalary=0.07*eBean.getCurrentSalary();
				
				
				
				if(eBean.getManagerRating()==5)
					ratingSalary=0.1*eBean.getCurrentSalary();
				else if(eBean.getManagerRating()==4)
					ratingSalary=0.09*eBean.getCurrentSalary();
				else if(eBean.getManagerRating()==3)
					ratingSalary=0.08*eBean.getCurrentSalary();
				else if(eBean.getManagerRating()==2)
					ratingSalary=0.07*eBean.getCurrentSalary();
				else if(eBean.getCurrentSalary()==1)
					ratingSalary=0.06*eBean.getCurrentSalary();
				else
					ratingSalary=eBean.getCurrentSalary();

				finalSalary=eBean.getCurrentSalary()+newSalary+ratingSalary;

				return String.valueOf(finalSalary);
				
			}
			else
				return "HIKE PERCENTAGE INVALID";				
				
	}
	
	public String getAppraisalDetails(EmployeeBean eBean) throws InvalidADIDException, InvalidBUException, InvalidDOJException, InvalidCurrentSalaryException {
		
		computeAppraisal(eBean);
		
		if(finalSalary>=eBean.getCurrentSalary()) {
			eBean.setCurrentSalary(finalSalary);
			return eBean.getADID()+":"+eBean.getCurrentSalary();
		}else {
			return eBean.getADID()+":"+"Invalid Date of Joining";
		}
	}
	
}
	

