package com.jiteshp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jiteshp.model.Employee;
import com.jiteshp.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String listemployee(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("emlopyeeList", employeeService.listEmployee());
		return "employee";

	}

	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public String addemployee(@ModelAttribute("employee") Employee employee) {
		if (employee.getEmpolyeeId() == null || employee.getEmpolyeeId() == 0) {
			employeeService.addEmployee(employee);
		} else {
			// existing employee
			employeeService.updateEmployee(employee);
		}
		return "redirect:/employees";
	}

	@RequestMapping("/employee/remove/{id}")
	public String removeemployee(@PathVariable("id") int id) {
		employeeService.removeEmployee(id);
		return "redirect:/employees";
	}

	@RequestMapping("/employee/edit/{id}")
	public String editemployee(@PathVariable("id") int id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		model.addAttribute("employeeList", employeeService.listEmployee());
		return "employee";
}

}
