package com.pepcus.employee.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pepcus.employee.modal.Book;
@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

 

}
