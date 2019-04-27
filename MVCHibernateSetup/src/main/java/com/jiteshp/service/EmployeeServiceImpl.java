package com.jiteshp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jiteshp.dao.EmployeeDAO;
import com.jiteshp.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	public void setemployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

	@Override
	public void addEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeDAO.getEmployeeById(id);
	}

	@Override
	public void removeEmployee(int id) {
		employeeDAO.removeEmployee(id);
		
	}

	@Override
	public List<Employee> listEmployee() {
		return employeeDAO.listEmployees();
	}

	
}
