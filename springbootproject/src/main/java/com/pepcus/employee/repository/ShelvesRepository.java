package com.pepcus.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pepcus.employee.modal.Shelves;

@Repository
public interface ShelvesRepository extends JpaRepository<Shelves, Integer> {

}
