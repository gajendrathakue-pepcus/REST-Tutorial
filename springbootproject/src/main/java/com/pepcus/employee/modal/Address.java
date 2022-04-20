package com.pepcus.employee.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer address_id;
  private String street1;
  private String street2;
  private String city;
  private String state;
  private String country;

  public Address(Integer address_id, String street1, String street2, String city, String state, String country) {
    super();
    this.address_id = address_id;
    this.street1 = street1;
    this.street2 = street2;
    this.city = city;
    this.state = state;
    this.country = country;
  }

  public Address() {
  }

  public Integer getAddress_id() {
    return address_id;
  }

  public void setAddress_id(Integer address_id) {
    this.address_id = address_id;
  }

  public String getStreet1() {
    return street1;
  }

  public void setStreet1(String street1) {
    this.street1 = street1;
  }

  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

}
