package com.springboot.studentdata.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Attendance")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Attendance {
  @Id
  private int id;
  private int day;
  private String isPresent;
  private int student_id;

}