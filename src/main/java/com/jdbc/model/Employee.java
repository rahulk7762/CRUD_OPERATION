package com.jdbc.model;

public class Employee {
private int id,salary;
private String name,department,address;

public Employee() {
	super();
	
}


public Employee(int id,String name,String department,String address,int salary) {
	super();
	this.id = id;
	this.name = name;
	this.department = department;
	this.address = address;
	this.salary = salary;
}

public void setId(int id) {
	this.id = id;
}
public int getId() {
	return id;
}

public void setName(String name) {
	this.name = name;
}

public String getName() {
	return name;
}


public int getSalary() {
	return salary;
}


public void setSalary(int salary) {
	this.salary = salary;
}


public String getDepartment() {
	return department;
}


public void setDepartment(String department) {
	this.department = department;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


@Override
public String toString() {
	return "Employee [id=" + id + ", salary=" + salary + ", name=" + name + ", department=" + department + ", address="
			+ address + "]";
}






}
