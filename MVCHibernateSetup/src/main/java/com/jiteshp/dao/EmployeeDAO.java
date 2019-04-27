package com.jiteshp.dao;

import java.util.List;

import com.jiteshp.model.Employee;

public interface EmployeeDAO {
	
	public void addEmployee(Employee mEmployee);
	public void updateEmployee(Employee mEmployee);
	public Employee getEmployeeById(int id);
	public void removeEmployee(int id);
	public List<Employee> listEmployees();
	


}
