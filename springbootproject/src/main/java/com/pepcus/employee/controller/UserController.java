package com.pepcus.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pepcus.employee.modal.User;
import com.pepcus.employee.repository.BookRepository;
import com.pepcus.employee.repository.UserRepository;
import com.pepcus.employee.service.UserService;

import exception.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private UserService userService;
  
  @Autowired
  UserRepository userRepository;
  
  @Autowired
  BookRepository bookRepository;
  
  @PostMapping
  public User registerUser(@RequestBody User user) {
      return userService.saveUser(user);
  }

  @DeleteMapping("{userId}")
  public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {

      User user = userRepository.findById(userId)
              .orElseThrow(() -> new ResourceNotFoundException("User does not exist with id: " + userId));

      return userService.deRegisterUser(user,userId);
  }

  @PatchMapping("book-issue/{userId}/{bookId}")
  public ResponseEntity<String> issueBook(@PathVariable Integer userId, @PathVariable Integer bookId) {
      return userService.issueABook(userId,bookId);
  }

  @PatchMapping("book-return/{userId}/{bookId}")
  public ResponseEntity<String> returnBook(@PathVariable Integer userId, @PathVariable Integer bookId) {
      return userService.returnABook(userId,bookId);
  }
}
