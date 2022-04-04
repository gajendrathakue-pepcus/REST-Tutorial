package com.pepcus.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pepcus.employee.modal.Employee;
import com.pepcus.employee.service.EmployeeSrvice;

@RestController
@RequestMapping(value = "/Empl")
public class Controller {
	@Autowired
	EmployeeSrvice employeeservice;

	@PostMapping("/insert")
	public Employee insertEmployee(@RequestBody Employee employee) {
		Employee emp = employeeservice.insertEmployee(employee);
		return emp;
	}

	@GetMapping("/allEmployee")
	public List<Employee> getAllEmployee() {
		List<Employee> employee = employeeservice.getAllEmployee();
		System.out.println(employee);
		return employee;
	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee Emp = employeeservice.insertEmployee(employee);
		System.out.println(employee);
		return Emp;
	}

	@DeleteMapping("/delete/{id}")
	public String getDeleteEmployeeById(@PathVariable("id") int id) {
		System.out.println("book id-->" + id);
		String successfull = employeeservice.getDeleteEmployeeById(id);
		return successfull;
	}

}
