package com.example.CarApp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Owner {

    

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long ownerid;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="owner")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    private List<Car> cars;
    
    private String fristName;
    private String lastName;
    
    
    public Owner()
    {}
    
    
    public Owner(String fristName, String lastName) {
        super();
        this.fristName = fristName;
        this.lastName = lastName;
    }



    public long getOwnerid() {
        return ownerid;
    }



    public void setOwnerid(long ownerid) {
        this.ownerid = ownerid;
    }



    public String getFristName() {
        return fristName;
    }



    public void setFristName(String fristName) {
        this.fristName = fristName;
    }



    public String getLastName() {
        return lastName;
    }



    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    
    
}