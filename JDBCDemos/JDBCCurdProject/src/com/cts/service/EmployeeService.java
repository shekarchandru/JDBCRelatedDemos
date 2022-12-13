package com.cts.service;

import java.util.ArrayList;

import com.cts.dao.EmployeeDAO;
import com.cts.model.Employee;

public class EmployeeService {
	
	EmployeeDAO edao;
	
	public EmployeeService()
	{
		edao = new EmployeeDAO();
	}
	
	public ArrayList <Employee> getEmployeeRecords()
	{
		ArrayList <Employee> employees = new ArrayList<Employee>();
		employees = edao.getAllEmployees();
		return employees;
	}
	
	public Employee searchEmployeeById(String empId)
	{
		Employee e = new Employee();
		e = edao.getEmployeeById(empId);
		return e;
	}
	
	public boolean insertEmployeeRecord(Employee emplI)
	{
		boolean flag = false;
		
		flag =  edao.insertEmployee(emplI);
		return flag;
	}
	
	public boolean updateEmployeeRecord(Employee emplU)
	{
		boolean flag = false;
		
		flag = edao.updateEmployee(emplU);
		
		return flag;
	}
	public boolean deleteEmployeeRecord(String empId)
	{
		boolean flag = false;
		
		flag = edao.deleteEmployeeById(empId);
		
		return flag;
	}
	public ArrayList <String> getAllEmployeeIds()
	{
		ArrayList <String> ids = new ArrayList<String>();
		ids = edao.getEmployeeIds();
		return ids;
	}
	public String fetchMaxEmployeeId()
	{
		String maxEmpId="";
		maxEmpId = edao.getMaxEmployeeId();
		return maxEmpId;
	}

}
