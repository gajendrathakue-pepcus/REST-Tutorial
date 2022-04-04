package com.pepcus.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pepcus.employee.modal.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
