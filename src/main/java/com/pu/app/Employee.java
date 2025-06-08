package com.pu.app;

import org.springframework.stereotype.Component;

@Component
public class Employee 
{
	private int empId;
	private String eName;
	private double eSalary;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId, String eName, double eSalary) {
		super();
		this.empId = empId;
		this.eName = eName;
		this.eSalary = eSalary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public double geteSalary() {
		return eSalary;
	}
	public void seteSalary(double eSalary) {
		this.eSalary = eSalary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", eName=" + eName + ", eSalary=" + eSalary + "]";
	}
	
	
}
