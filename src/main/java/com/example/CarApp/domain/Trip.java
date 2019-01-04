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

@Entity
public class Trip {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long tripId;
	private String tripName;
	
	public Trip() {}
	
	public Trip(Long tripId, String tripName) {
		super();
		this.tripId = tripId;
		this.tripName = tripName;
	}
	
	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "car_trip", joinColumns = { @JoinColumn(name =
     "tripId") }, inverseJoinColumns = { @JoinColumn(name = "id") }) 
    private Set<Car> cars = new HashSet<Car>(0); 

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	}
	
}
