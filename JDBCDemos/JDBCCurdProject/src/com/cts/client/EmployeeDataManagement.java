package com.cts.client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.cts.model.Employee;
import com.cts.service.EmployeeService;

public class EmployeeDataManagement {
	
	Connection con;
	ResultSet rs;
	String ans;
	int option;
	Scanner scan1;
	EmployeeService empService;
	ArrayList <Employee> employees;
	Employee emp;
	
	public EmployeeDataManagement()
	{
		ans="yes";
		scan1 = new Scanner(System.in);
		empService = new EmployeeService();
	}
	public void displayEmployeesRecords()
	{
		employees = empService.getEmployeeRecords();
		Iterator empIter = employees.iterator();
		while(empIter.hasNext())
		{
			Employee e =(Employee)empIter.next();
			System.out.println(e);
		}
	}
	public void displayExistingEmployeeIds()
	{
		ArrayList <String> employeeIds = new ArrayList<String>();
		employeeIds = empService.getAllEmployeeIds();
		Iterator idIter = employeeIds.iterator();
		System.out.println("The Employee Ids Are...");
		while(idIter.hasNext())
		{
			String idStr = (String)idIter.next();
			System.out.println(idStr);
			
		}
		
	}
	public boolean checkIfIdExists(String eId)
	{
		boolean flag = false;
		ArrayList <String> employeeIds = new ArrayList<String>();
		employeeIds = empService.getAllEmployeeIds();
		Iterator idIter = employeeIds.iterator();
		String existingId;
		while(idIter.hasNext())
		{
			existingId = (String)idIter.next();
			if(existingId.equals(eId))
			{
				flag = true;
				break;
			}
			else
			{
				flag = false;
			}
		}
		return flag;
	}
	public String generateEmployeeId()
	{
		String newEmpId="";
		String maxId="";
		maxId= empService.fetchMaxEmployeeId();
		String preId="",postId="";
		//Finding PreFix Part of E001 as E
		// and Finding PostFix part of E001 as 001
		preId = maxId.substring(0, 1);
		postId = maxId.substring(1, 4);
		//E001 to E999
		//Converting PostFix part to Integer
		int postNum = Integer.parseInt(postId);
		//Incrementing the PostFix part
		postNum+=1;
		//ASSUMPTION IS 999 employees
		if((postNum >= 0) &&(postNum <= 9))
		{
			newEmpId = "E00"+postNum;
		}
		else if((postNum > 9) &&(postNum <= 99))
		{
			newEmpId = "E0"+postNum;
		}
		else if((postNum > 99) &&(postNum <= 999))
		{
			newEmpId = "E"+postNum;
		}
		else
		{
			newEmpId ="Invalid";
		}
		return newEmpId;
	}
	public void showMenu()
	{
		while(ans.equals("yes") || ans.equals("YES"))
		{
			System.out.println("............. Employee Details Management Menu.........");
			System.out.println("1.View All Employees");
			System.out.println("2.Search Employee By ID");
			System.out.println("3.Insert Employee Record");
			System.out.println("4.Delete Employee ID");
			System.out.println("5.Update Employee");
			System.out.println("6.Exit");
			
			System.out.println("Please enter Your Option...");
			option = scan1.nextInt();
			switch(option)
			{
				case 1:
				{
					System.out.println("Viewing All Employees...");
					displayEmployeesRecords();
					break;
				}
				case 2:
				{
					System.out.println("Searching Employee By Id...");
					String emplId;
					displayExistingEmployeeIds();
					System.out.println("Please Enter the Employee Id whose record you wish to see...");
					emplId = scan1.next();
					if(checkIfIdExists(emplId))
					{
						emp = empService.searchEmployeeById(emplId);
						System.out.println("The Employee is "+emp);
					}
					else
					{
						System.out.println("Sorry Employee ID Does not Exist....");
					}
					break;
				}
				case 3:
				{
					System.out.println("Inserting Employee Record...");
					
					emp = new Employee();
					String eId,eName,eAddress,ePhone;
					int eSalary;
					float eTax;
					
				/*	System.out.println("Enter the Id of The Employee You wish to Insert");
					eId = scan1.next();*/
					eId = generateEmployeeId();
					System.out.println("The New Id Generated is "+eId);
					System.out.println("Enter the Name of The Employee You wish to Insert");
					eName = scan1.next();
					System.out.println("Enter the Address of The Employee You wish to Insert");
					eAddress = scan1.next();
					System.out.println("Enter the Phone of The Employee You wish to Insert");
					ePhone = scan1.next();
					System.out.println("Enter the Salary of The Employee You wish to Insert");
					eSalary = scan1.nextInt();
					System.out.println("Enter the Tax Eligibility of The Employee You wish to Insert");
					eTax = scan1.nextFloat();
					
					emp.setEmployeeId(eId);
					emp.setEmployeeName(eName);
					emp.setEmployeeAddress(eAddress);
					emp.setEmployeePhone(ePhone);
					emp.setEmployeeSalary(eSalary);
					emp.setEmployeeTax(eTax);
					
					boolean insertionResult = empService.insertEmployeeRecord(emp);
					if(insertionResult == true)
					{
						System.out.println("Record Inserted Successfully...");
					}
					else
					{
						System.out.println("Insertion failed....");
					}
					break;
				}
				case 4:
				{
					String eId;
					boolean flag = false;
					System.out.println("Deleting Employee Record by Id");
					System.out.println("You Are about to Delete a Record...");
					displayExistingEmployeeIds();
					System.out.println("Please enter the ID of the Employee whose Record you wish to Delete...");
					eId = scan1.next();
					if(checkIfIdExists(eId))
					{
						flag = empService.deleteEmployeeRecord(eId);
						if(flag)
						{
							System.out.println("Deleted The Record of "+eId+"  Successfully...");
						}
						else
						{
							System.out.println("Deletion Failed....");
						}
					}
					else
					{
						System.out.println("Sorry Employee ID Does not Exist...");
					}
					break;
				}
				case 5:
				{
					emp = new Employee();
					String eId,eName,eAddress,ePhone;
					int eSalary;
					float eTax;
					boolean flag=false;
					String empIdForUpdate;
					System.out.println("Updating Employee Record...");
					System.out.println("Records Existing are....");
					
					displayEmployeesRecords();

					System.out.println("Enter the Id of the Employee Whose Record you wish to Update....");
					empIdForUpdate = scan1.next();
					if(checkIfIdExists(empIdForUpdate))
					{
						System.out.println("Enter the New Name of The Employee You wish to Update");
						eName = scan1.next();
						System.out.println("Enter the New Address of The Employee You wish to Update");
						eAddress = scan1.next();
						System.out.println("Enter the New Phone of The Employee You wish to Update");
						ePhone = scan1.next();
						System.out.println("Enter the New Salary of The Employee You wish to Update");
						eSalary = scan1.nextInt();
						System.out.println("Enter the New Tax Eligibility of The Employee You wish to Update");
						eTax = scan1.nextFloat();
						
						emp = new Employee(empIdForUpdate,eName,eAddress,ePhone,eSalary,eTax);
						flag = empService.updateEmployeeRecord(emp);
						if(flag)
						{
							System.out.println("Updated Record for Employee with Id "+empIdForUpdate);
						}
						else
						{
							System.out.println("Updation Failed.....");
						}
					}
					else
					{
						System.out.println("Sorry Employee Id Does not Exist....");
					}
					break;
				}
				case 6:
				{
					System.out.println("Exiting Application...");
					//System.exit(0);
					break;
				}
				default:
				{
					break;
				}
					
			
			}
			
			System.out.println("Do You Wish to Continue yes/no?");
			ans = scan1.next();
		}
		System.out.println("We are out of Menu...");
	}
	

}
