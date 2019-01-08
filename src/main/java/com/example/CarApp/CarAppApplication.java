package com.example.CarApp;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.CarApp.domain.Car;
import com.example.CarApp.domain.CarRepositor;
import com.example.CarApp.domain.Owner;
import com.example.CarApp.domain.OwnerRepository;
import com.example.CarApp.domain.Trip;
import com.example.CarApp.domain.TripRepository;


@SpringBootApplication
public class CarAppApplication {
	
	@Autowired 
    private CarRepositor repository;

    @Autowired 
    private OwnerRepository orepository;
    
    @Autowired
    private TripRepository trepository;
	
	private static final Logger logger = LoggerFactory.getLogger(CarAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarAppApplication.class, args);
		
		logger.info("Hello Spring Boot");
	}
		@Bean
        CommandLineRunner runner(){
		
          return args -> {
        	// Add owner objects and save these to db
              Owner owner1 = new Owner("John" , "Johnson");
              Owner owner2 = new Owner("Mary" , "Robinson");
              Owner owner3 = new Owner("Ashly" , "Gibson");
              orepository.save(owner1);
              orepository.save(owner2);
              orepository.save(owner3);
              
              HashSet<Owner> o = new HashSet<Owner>();
              o.add(owner1);
              o.add(owner2);
        	  
        	  //Add trip objects and save them into DB
        	  Trip trip1 = new Trip("Summer Time", "Haifa beach", "swimming",o);
        	  Trip trip2 = new Trip("Spring Time", "Mount Gilboa", "walking",o);
        	  Trip trip3 = new Trip("Winter Time", "Mount Hermon", "Skiing",owner3);
        	  trepository.save(trip1);
        	  trepository.save(trip2);
        	  trepository.save(trip3);
        	  
              
              // Add car object with link to owners and save these to db.
              Car car = new Car("Ford", "Mustang", "Red", 
                  "ADF-1121", 2017, 59000, owner1);
              repository.save(car);
              car = new Car("Nissan", "Leaf", "White",
                  "SSJ-3002", 2014, 29000, owner2);
              repository.save(car);
              car = new Car("Toyota", "Prius", "Silver",
                  "KKO-0212", 2018, 39000, owner2);
              repository.save(car);
              car = new Car("Siat", "Ibiza", "Red",
                      "BXN-4502", 2013, 26000, owner3);
                  repository.save(car);
              
          };
		
	}

}

