package com.pepcus.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pepcus.employee.modal.Book;
import com.pepcus.employee.modal.Shelves;
import com.pepcus.employee.service.ShelvesService;

@RestController
@RequestMapping(value="/shalves")
public class ShelvesController {
  @Autowired
  ShelvesService shelvesService;
  @PostMapping("/")
  public Shelves addShelves(@RequestBody Shelves shelves) {
    Shelves shelvesResponse = shelvesService.addShelves(shelves);
    return shelvesResponse;
  }

  @PatchMapping("addBooks/{id}")
  public Shelves addBook(@PathVariable Integer id, @RequestBody List<Book> books) {
      return shelvesService.addBooksToShelf(id,books);
  }
}
