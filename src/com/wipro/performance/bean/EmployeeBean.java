package com.wipro.performance.bean;

import java.util.Date;

public class EmployeeBean {
	
	private String ADID;
	private String empName;
	private String businessUnit;
	private Date dateOfJoining;
	private double currentSalary;
	private double totalAttendance;
	private double managerRating;
	public EmployeeBean() {
		// TODO Auto-generated constructor stub
	}
	public EmployeeBean(String aDID, String empName, String businessUnit, Date dateOfJoining, double currentSalary,
			double totalAttendance, double managerRating) {
		super();
		ADID = aDID;
		this.empName = empName;
		this.businessUnit = businessUnit;
		this.dateOfJoining = dateOfJoining;
		this.currentSalary = currentSalary;
		this.totalAttendance = totalAttendance;
		this.managerRating = managerRating;
	}
	public String getADID() {
		return ADID;
	}
	public void setADID(String aDID) {
		ADID = aDID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public double getCurrentSalary() {
		return currentSalary;
	}
	public void setCurrentSalary(double currentSalary) {
		this.currentSalary = currentSalary;
	}
	public double getTotalAttendance() {
		return totalAttendance;
	}
	public void setTotalAttendance(double totalAttendance) {
		this.totalAttendance = totalAttendance;
	}
	public double getManagerRating() {
		return managerRating;
	}
	public void setManagerRating(double managerRating) {
		this.managerRating = managerRating;
	}
	@Override
	public String toString() {
		return "EmployeeBean [ADID=" + ADID + ", empName=" + empName + ", businessUnit=" + businessUnit
				+ ", dateOfJoining=" + dateOfJoining + ", currentSalary=" + currentSalary + ", totalAttendance="
				+ totalAttendance + ", managerRating=" + managerRating + "]";
	}
}
