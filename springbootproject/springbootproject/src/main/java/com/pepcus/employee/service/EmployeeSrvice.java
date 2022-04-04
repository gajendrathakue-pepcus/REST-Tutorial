package com.pepcus.employee.service;

import java.util.List;

import com.pepcus.employee.modal.Employee;

public interface EmployeeSrvice {

	Employee insertEmployee(Employee employee);

	List<Employee> getAllEmployee();

	String getDeleteEmployeeById(int id);
    
}
