package com.pepcus.employee.modal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.pepcus.employee.modal.*;
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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userId;

  private String userName;

  private Date registrationDate;

  private Date deactivationDate;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "uId")
  private List<Book> bookIssuedList = new ArrayList<>();
}
