package com.pu.app;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employee")
public class EmpController 
{
	@Autowired
	private EmpService eService;
	
	@GetMapping(path = "/list",produces = "application/json")
	public String getallemps()throws ClassNotFoundException,SQLException
	{
		String res="";
		try {
			res= eService.getAllEmployees();
		} catch (Exception e) {
			e.printStackTrace();		}
		return res;
	}
	
	
	@PostMapping(path = "/insert",produces = "application/json")
	public String addEmployee(@RequestBody Employee employee)throws ClassNotFoundException,SQLException
	{
		String res="";
		try {
		res=eService.InsertEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
		}
	
	@PutMapping(path = "/update/{empId}",produces = "application/json")
	public String updateEmp(@PathVariable("empId") int empId,@RequestBody Employee new_Employee )throws ClassNotFoundException,SQLException
	{
		String res="";
		try {
			res+=eService.updateEmployee(empId, new_Employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@DeleteMapping(path = "/delete/{empId}",produces = "application/json")
	public String deleteEmp(@PathVariable("empId")int empId)throws ClassNotFoundException,SQLException
	{
		String res="";
		try {
			res+=eService.deleteEmployee(empId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
