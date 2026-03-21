package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.model.Employee;

public class EmpoyeeDaoImpl implements EmployeeDao {

	private static Connection connection;
	
	
	static {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static final String INSERT_QUERY ="INSERT INTO employees(id, name, department, address, salary) VALUES (?, ?, ?, ?, ?)";
	public static final String UPDATE_QUERY = "UPDATE employees SET name=?, department=?, address=?, salary=? WHERE id=?";
	public static final String DELETE_QUERY = "DELETE FROM employees WHERE id=?";
	public static final String GET_EMPLOYEEBYID = "SELECT * FROM employees WHERE id=?";
	public static final String GET_EMPLOYEEBYNAME = "SELECT * FROM employees WHERE name = ?";
	public static final String GET_ALLEMPLOYEES = "SELECT * FROM employees";
	
	
	@Override
	public void createTable() throws SQLException {
		// TODO Auto-generated method stub
		Statement statement = connection.createStatement();
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS employees(id INT PRIMARY KEY,name VARCHAR(50),department VARCHAR(50),address VARCHAR(50),salary INT)");
		
//		statement.executeUpdate("CREATE TABLE IF NOT EXISTS employee(empId INT PRIMARY KEY, name VARCHAR(100),email VARCHAR(100),contact BIGINT,salary DOUBLE)");
		
		
		System.out.println("EmpoyeeDaoImpl.createTable()");
		
	}

	@Override
	public void saveEmployee(Employee e) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
		ps.setInt(1,e.getId());
		ps.setString(2,e.getName());
		ps.setString(3,e.getDepartment());
		ps.setString(4,e.getAddress());
		ps.setInt(5,e.getSalary());
		ps.executeUpdate();
		
		System.out.println("EmpoyeeDaoImpl.saveEmployee()");
	}

	@Override
	public void UpdateEmployee(Employee e) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
		
		ps.setString(1, e.getName());
		ps.setString(2, e.getDepartment());
		ps.setString(3, e.getAddress());
		ps.setInt(4, e.getSalary());
		ps.setInt(5,e.getId());
		
		ps.executeUpdate();
		System.out.println("EmpoyeeDaoImpl.UpdateEmployee()");
		
	}

	@Override
	public void deleteEmployee(int id) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = connection.prepareStatement(DELETE_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
		System.out.println("EmpoyeeDaoImpl.deleteEmployee()");
		
	}

	@Override
	public Employee getEmplbyId(int id) throws SQLException {
		// TODO Auto-generated method stub
	PreparedStatement ps = connection.prepareStatement(GET_EMPLOYEEBYID);
	ps.setInt(1, id);
		ResultSet resultSet  =  ps.executeQuery();
		resultSet.next();
		Employee emp = new Employee();
		emp.setId(id);
		emp.setName(resultSet.getString(2));
		emp.setDepartment(resultSet.getString(3));
		emp.setAddress(resultSet.getString(4));
		emp.setSalary(resultSet.getInt(5));
		System.out.println("EmpoyeeDaoImpl.getEmplbyId()");
		return emp;
	}

	@Override
	public Employee getEmplbyName(String name) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("EmpoyeeDaoImpl.getEmplbyName()");
		
		
		PreparedStatement ps = connection.prepareStatement(GET_EMPLOYEEBYNAME);
		ps.setString(1, name);
		  ResultSet resultSet =  ps.executeQuery();
		  resultSet.next();
		  Employee emp = new Employee();
		  emp.setId(resultSet.getInt(1));
		  emp.setName(name);
		  emp.setDepartment(resultSet.getString(3));
		  emp.setAddress(resultSet.getString(4));
		  emp.setSalary(resultSet.getInt(5));
		return emp;
	}

	@Override
	public List<Employee> getAllEmp() throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("EmpoyeeDaoImpl.getAllEmp()");
		
		PreparedStatement ps = connection.prepareStatement(GET_ALLEMPLOYEES);

		ResultSet resultSet = ps.executeQuery();
		
		List<Employee> emplist = new ArrayList<>();
		
		while(resultSet.next()) {
			Employee e = new Employee();
			e.setId(resultSet.getInt(1));
			e.setName(resultSet.getString(2));
			e.setDepartment(resultSet.getString(3));
			e.setAddress(resultSet.getString(4));
			e.setSalary(resultSet.getInt(5));
			
			emplist.add(e);
		}
		
		return emplist;
	}

}
