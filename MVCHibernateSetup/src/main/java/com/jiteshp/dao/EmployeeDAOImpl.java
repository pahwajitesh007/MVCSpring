package com.jiteshp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiteshp.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public void addEmployee(Employee mEmployee) {
		Session session = sessionfactory.getCurrentSession();
		session.persist(mEmployee);

	}

	@Override
	public void updateEmployee(Employee mEmployee) {
		Session session = sessionfactory.getCurrentSession();
		session.update(mEmployee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		Session mSession = sessionfactory.getCurrentSession();
		Employee mEmployee = (Employee) mSession.get(Employee.class, new Integer(id));
		return mEmployee;
	}

	@Override
	public void removeEmployee(int id) {
		Session mSession = sessionfactory.getCurrentSession();
		Employee mEmployee = (Employee) mSession.get(Employee.class, new Integer(id));
		if (mEmployee != null) {
			mSession.delete(mEmployee);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listEmployees() {
		Session session = sessionfactory.getCurrentSession();
		List<Employee> mList = session.createQuery("From Employee").list();
		return mList;
	}

}
