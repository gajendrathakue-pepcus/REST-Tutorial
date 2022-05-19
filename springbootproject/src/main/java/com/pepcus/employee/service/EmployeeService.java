package com.pepcus.employee.service;

import java.util.List;

import com.pepcus.employee.modal.Employee;

public interface EmployeeService {

	Employee insertEmployee(Employee employee);

	List<Employee> getAllEmployee();

	String getDeleteEmployeeById(int id);

	Employee updateEmployee(Employee employee);

	List<Employee> findAllOrderByNameAsc();

	List<Employee> filterByDepartment(String name);


    
}




