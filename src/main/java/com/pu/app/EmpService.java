package com.pu.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService 
{
	@Autowired
	private dbhandler db;
	
	public String getAllEmployees()throws ClassNotFoundException,SQLException
	{
		String result="";
		try {
			Connection con=db.getConnection();
			Statement st=con.createStatement();
			ResultSet rSet=st.executeQuery("SELECT * FROM employee");
			while(rSet.next())
			{
				result += rSet.getInt(1)+ "  "+rSet.getString(2)+"  "+rSet.getDouble(3)+"\n";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	public String InsertEmployee(Employee employee)throws ClassNotFoundException,SQLException
	{
		String result="";
		try {
			Connection con=db.getConnection();
			
			PreparedStatement pStatement=con.prepareStatement("INSERT INTO employee(empId,eName,eSalary) VALUES(?,?,?)");
			pStatement.setInt(1,(Integer)employee.getEmpId());
			pStatement.setString(2,(String)employee.geteName());
			pStatement.setDouble(3,(double)employee.geteSalary());
			
			int res=pStatement.executeUpdate();
			if(res>0)
			{
				result+="Employee Data Inserted Successfully to the Database...😊😊😊";
			}
			else {
				result+="Unable to insert the Employee Data to the Database...😊😊😊";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public String updateEmployee(int empId,Employee new_employee)throws ClassNotFoundException,SQLException
	{
		String resultString="";
		try {
			Connection con=db.getConnection();
			PreparedStatement pStatement=con.prepareStatement(
					"UPDATE employee SET eName=?,eSalary=? WHERE empId=?");
			pStatement.setString(1,(String) new_employee.geteName());
			pStatement.setDouble(2,(Double) new_employee.geteSalary());
			pStatement.setInt(3,(Integer) new_employee.getEmpId());
					
			int res= pStatement.executeUpdate();
			if(res>0)
			{
				resultString+="Employee data has been successfully updated in the database..😊😊😊 ";
			}
			else {
				resultString+=" Unable to update the employee data in the database..😔😔😔 ";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultString;
	}
	
	
	public String deleteEmployee(int empId)throws ClassNotFoundException,SQLException
	{
		String resultString="";
		try {
			Connection con=db.getConnection();
			PreparedStatement pStatement=con.prepareStatement(
					"DELETE FROM employee WHERE empId=?");
			
			pStatement.setInt(1,(Integer) empId);
					
			int res= pStatement.executeUpdate();
			if(res>0)
			{
				resultString+="Employee data has been successfully deleted in the database..😊😊😊 ";
			}
			else {
				resultString+=" Unable to delete the employee data in the database..😔😔😔 ";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultString;
	}
}
