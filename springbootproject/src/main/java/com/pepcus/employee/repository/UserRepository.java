package com.pepcus.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pepcus.employee.modal.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
