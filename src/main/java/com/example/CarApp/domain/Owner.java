package com.example.CarApp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Owner {
  
  private long ownerid;
  private String firstname, lastname;
  
  
 
  private List<Car> cars;
  
  @OneToMany( mappedBy="owner", cascade = CascadeType.ALL)
  //@JoinColumn(name = "cars")
  public List<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
  }


  public Owner() {}

  public Owner(String firstname, String lastname) {
    super();
    this.firstname = firstname;
    this.lastname = lastname;
  }

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public long getOwnerid() {
    return ownerid;
  }
  public void setOwnerid(long ownerid) {
    this.ownerid = ownerid;
  }
  public String getFirstname() {
    return firstname;
  }
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }
  public String getLastname() {
    return lastname;
  }
  public void setLastname(String lastname) {
    this.lastname = lastname;
  } 
  
}



