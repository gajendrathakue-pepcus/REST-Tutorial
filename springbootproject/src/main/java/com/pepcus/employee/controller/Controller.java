package com.pepcus.employee.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pepcus.employee.modal.Employee;
import com.pepcus.employee.repository.EmployeeRepository;
import com.pepcus.employee.service.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class Controller {
  @Autowired
  EmployeeService employeeService;
  EmployeeRepository employeeRepository;

  @PostMapping("/")
  public Employee insertEmployee(@RequestBody Employee employee) {
    Employee employeeResponse = employeeService.insertEmployee(employee);
    return employeeResponse;
  }

  @GetMapping("/")
  public List<Employee> getAllEmployee() {
    List<Employee> employee = employeeService.getAllEmployee();
    System.out.println(employee);
    return employee;
  }

  @PutMapping("/{id}")
  public Employee updateEmployee(@RequestBody Employee employee) {
    Employee employee1 = employeeService.updateEmployee(employee);
    System.out.println(employee);
    return employee1;
  }

  @DeleteMapping("/{id}")
  public String getDeleteEmployeeById(@PathVariable("id") int id) {
    System.out.println("book id-->" + id);
    String successfull = employeeService.getDeleteEmployeeById(id);
    return successfull;
  }

  @GetMapping("/findAllOrderByName")
  public List<Employee> findAllOrderByNameAsc() {

    return employeeService.findAllOrderByNameAsc();
  }

  @GetMapping("/filterByDepartment")
  public List<Employee> filterByDepartment(@RequestParam(value = "department", required = false) String department) {

    return employeeService.filterByDepartment(department);
  }
  
  @GetMapping("/employeePageable")
   Page employeePageable(Pageable pageab) {

    return employeeRepository.findAll(pageab);
  }

}
