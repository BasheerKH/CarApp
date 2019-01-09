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
public class Trip {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long tripId;
	private String tripName, tripPlace, tripActivity;
	
	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "trip_owner", joinColumns = { @JoinColumn(name ="tripId", referencedColumnName = "tripId") }, 
    						inverseJoinColumns = { @JoinColumn(name = "ownerid", referencedColumnName = "ownerid") })
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    private Set<Owner> owners = new HashSet<Owner>(0);
	
	public Set<Owner> getOwners() {
		return owners;
	}

	public void setOwners(Set<Owner> owners) {
		this.owners = owners;
	}

	public Trip() {}
	
	public Trip(String tripName, String tripPlace, String tripActivity) {
		super();
		this.tripName = tripName;
		this.tripPlace = tripPlace;
		this.tripActivity = tripActivity;
		this.owners = null;
	}
	
	public Trip(String tripName, String tripPlace, String tripActivity, Set<Owner> owners) {
		super();
		this.tripName = tripName;
		this.tripPlace = tripPlace;
		this.tripActivity = tripActivity;
		this.owners = owners; 
	}

	public Trip(String tripName, String tripPlace, String tripActivity, Owner owner) {
		super();
		this.tripName = tripName;
		this.tripPlace = tripPlace;
		this.tripActivity = tripActivity;
		this.owners = new HashSet<Owner>();
		this.owners.add(owner);
	}

	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "trip_car", joinColumns = { @JoinColumn(name = "tripId", referencedColumnName = "tripId") }, 
    inverseJoinColumns = { @JoinColumn(name = "id", referencedColumnName = "id") }) 
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
	
	public String getTripPlace() {
		return tripPlace;
	}

	public void setTripPlace(String tripPlace) {
		this.tripPlace = tripPlace;
	}
	
	public String getTripActivity() {
		return tripActivity;
	}

	public void setTripActivity(String tripActivity) {
		this.tripActivity = tripActivity;
	}

}
