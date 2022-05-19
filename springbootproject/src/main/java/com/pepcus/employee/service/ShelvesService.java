package com.pepcus.employee.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pepcus.employee.modal.Book;
import com.pepcus.employee.modal.Shelves;
import com.pepcus.employee.repository.ShelvesRepository;

@Service
public class ShelvesService {
  @Autowired
  ShelvesRepository shelvesRepository;

  public Shelves addShelves(Shelves shelves) {
    shelvesRepository.save(shelves);
    return shelves;
  }

  public Shelves addBooksToShelf(Integer id, List<Book> books) {
    Shelves Shelf = shelvesRepository.getById(id);
    List<Book> existingBookList = Shelf.getBooks();
    for (Book book : books ) {
        existingBookList.add(book);
    }
    return shelvesRepository.save(Shelf);
}
   
  }


