package com.wipro.performance.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import com.wipro.performance.bean.EmployeeBean;
import com.wipro.performance.entity.EmployeeService;
import com.wipro.performance.exception.InvalidADIDException;
import com.wipro.performance.exception.InvalidBUException;
import com.wipro.performance.exception.InvalidCurrentSalaryException;
import com.wipro.performance.exception.InvalidDOJException;

public class EmployeeMain {

	public static void main(String[] args) throws InvalidADIDException, InvalidBUException, InvalidDOJException,
			InvalidCurrentSalaryException, ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		 Date dNow = new Date(); 
		 SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
		 System.out.println("Current Date: " + ft.format(dNow));
		 

		
		EmployeeBean eBean = new EmployeeBean();
		EmployeeService empService = new EmployeeService();
		
		eBean.setADID(sc.next());
		eBean.setEmpName(sc.next());
		eBean.setBusinessUnit(sc.next());
		Date sDate = ft.parse(sc.next());
		eBean.setDateOfJoining(sDate);
		eBean.setCurrentSalary(sc.nextDouble());
		eBean.setTotalAttendance(sc.nextDouble());
		eBean.setManagerRating(sc.nextDouble());

		System.out.println(eBean);
		System.out.println(empService.getAppraisalDetails(eBean));
		
		System.out.println("THIS");
		System.out.println("IS MAIN");
		System.out.println("BRANCH IN");
		System.out.println("GITHUB");
	}

}
