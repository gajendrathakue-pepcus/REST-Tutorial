package com.springboot.studentdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Student")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  @NotNull(message = "name can not be null")
  private String name;
  private String city;
  @Min(value = 1, message = "standard should be greater than ya equal to 1")
  @Max(value = 12, message = "standard shoulb be less than ya equal to 12")
  private int standard; 
  @Column(name = "email", unique = true)
  private String email;

}