package com.pepcus.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pepcus.employee.modal.Book;
import com.pepcus.employee.repository.BookRepository;

@Service
public class BookService {
@Autowired
BookRepository bookRepository;
  
  }


