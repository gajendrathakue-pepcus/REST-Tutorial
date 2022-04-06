package com.pepcus.employee.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pepcus.employee.modal.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	@Query("from Employee ORDER BY name ASC")

	List<Employee> findAllOrderByNameAsc();

	}

