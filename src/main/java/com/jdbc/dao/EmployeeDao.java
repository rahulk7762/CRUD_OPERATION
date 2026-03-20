package com.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import com.jdbc.model.Employee;

public interface EmployeeDao {

	public void createTable() throws SQLException;
	public void saveEmployee(Employee e) throws SQLException;
	public void UpdateEmployee(Employee e) throws SQLException;
	public void deleteEmployee(int id) throws SQLException;
	public Employee getEmplbyId(int id) throws SQLException;
	public Employee getEmplbyName(String name) throws SQLException;
	public List<Employee> getAllEmp() throws SQLException;
	
	
	
}
