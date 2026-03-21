package com.jdbc;

import java.sql.SQLException;
import java.util.List;

import com.jdbc.dao.EmployeeDao;
import com.jdbc.dao.EmpoyeeDaoImpl;
import com.jdbc.model.Employee;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Main.main()");
		
		Employee emp = new Employee(8,"Mohit kumar","java","Patna",35000);

		EmployeeDao EmpDao = new EmpoyeeDaoImpl();
//		---------------->  Creating Table  < ---------------------
//		EmpDao.createTable();
		
		
		
//		---------------->  Saving Employee in the Table  < ---------------------
		
//		EmpDao.saveEmployee(emp);
		
//		---------------->  Updating Employee in the Table  < ---------------------
		
//		EmpDao.UpdateEmployee(emp);
		
		
//		----------------> Deleting Employee From the Table  < ---------------------
		
//		EmpDao.deleteEmployee(1);
		
		
//		----------------> Get the Employee by id   <---------------------
		
//		Employee e = EmpDao.getEmplbyId(7);
//		System.out.println(e);
//		
		
		
//		----------------->  Get Employee by their Name     <---------
//		Employee e1 = EmpDao.getEmplbyName("Rohit kumar' OR '1'='1");  // Here SQL Injection failed bcz preparedStatement don't allow 
//		Employee e1 = EmpDao.getEmplbyName("Rohit kumar");
//		System.out.println(e1);
		
		
		
//		Get all the Employees in form of List
		
		List<Employee> list = EmpDao.getAllEmp();
		
		for(Employee emp1 : list) {
		    System.out.println(emp1);
		}
//		
		
		
		
		
		
		
	}

}
