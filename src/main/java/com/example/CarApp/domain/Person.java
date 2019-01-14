package com.example.CarApp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Person {
	
	
	private long pId;
	
	private String P_firstName, P_lastName;
	
	private Set<Trip> trips = new HashSet<Trip>(0);
    
	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "PersonInTrip", joinColumns = @JoinColumn(name = "pId", referencedColumnName = "pId"), 
    						inverseJoinColumns = @JoinColumn(name = "trip_id", referencedColumnName = "trip_id"))
	public Set<Trip> getTrips() {
		return trips;
	}

	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	}
	
	public Person() {}

	public Person(String p_firstName, String p_lastName) {
		super();
		P_firstName = p_firstName;
		P_lastName = p_lastName;
		this.trips = null;
	}

	public Person(String p_firstName, String p_lastName, Set<Trip> trips) {
		super();
		P_firstName = p_firstName;
		P_lastName = p_lastName;
		this.trips = trips;
	}
	
	public Person(String p_firstName, String p_lastName, Trip trips) {
		super();
		P_firstName = p_firstName;
		P_lastName = p_lastName;
		this.trips.add(trips);
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getpId() {
		return pId;
	}

	public void setpId(long pId) {
		this.pId = pId;
	}

	public String getP_firstName() {
		return P_firstName;
	}

	public void setP_firstName(String p_firstName) {
		P_firstName = p_firstName;
	}

	public String getP_lastName() {
		return P_lastName;
	}

	public void setP_lastName(String p_lastName) {
		P_lastName = p_lastName;
	}
	
	
}
