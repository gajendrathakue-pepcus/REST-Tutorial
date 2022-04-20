package com.pepcus.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pepcus.employee.modal.Address;
@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {


}
