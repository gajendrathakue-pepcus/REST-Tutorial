package com.pepcus.employee.modal;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.pepcus.employee.modal.Book;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Shelves")
@Setter
@Getter
@AllArgsConstructor
public class Shelves {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn
  private List<Book> books = new ArrayList<>();

}
