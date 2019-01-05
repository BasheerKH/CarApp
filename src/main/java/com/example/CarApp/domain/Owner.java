package com.example.CarApp.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Owner {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long ownerid;
    private String firstname, lastname;
    
	@ManyToMany(mappedBy = "owners")
	 private Set<Trip> trips; 
	

    public Owner() {}

    public Owner(String firstname, String lastname) {
      super();
      this.firstname = firstname;
      this.lastname = lastname;
    }

    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="owner")
    private List<Car> cars;
    
    public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

/*    
 * this code flow for many owners for many cars
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "car_owner", joinColumns = { @JoinColumn(name =
     "ownerid") }, inverseJoinColumns = { @JoinColumn(name = "id") }) 
    private Set<Car> cars = new HashSet<Car>(0); 
    
    public Set<Car> getCars() {
      return cars;
    }

    public void setCars(Set<Car> cars) {
      this.cars = cars;
    }
*/	


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
