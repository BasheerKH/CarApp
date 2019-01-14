package com.example.CarApp.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Trip {

	long trip_id;
	String tripName, tripPlace, tripActive;
	
	
	private Set<Car> cars;
	
	
	@ManyToMany(mappedBy = "trips")
	public Set<Car> getCars() {
		return cars;
	}
	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	private Set<Person> persons;
	
	@ManyToMany(mappedBy = "trips")
	//@JoinColumn(name = "persons")
	public Set<Person> getPersons() {
		return persons;
	}
	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(long trip_id) {
		this.trip_id = trip_id;
	}
	
	public Trip() {}
	
	public Trip(String tripName, String tripPlace, String tripActive) {
		super();
		this.tripName = tripName;
		this.tripPlace = tripPlace;
		this.tripActive = tripActive;
	}

	
	public String getTripName() {
		return tripName;
	}
	public void setTripName(String tripName) {
		this.tripName = tripName;
	}
	public String getTripPlace() {
		return tripPlace;
	}
	public void setTripPlace(String tripPlace) {
		this.tripPlace = tripPlace;
	}
	public String getTripActive() {
		return tripActive;
	}
	public void setTripActive(String tripActive) {
		this.tripActive = tripActive;
	}
	

}