package com.example.repository;

import org.springframework.transaction.annotation.Transactional;

import com.example.model.Booking;

import org.springframework.data.mongodb.repository.MongoRepository;

@Transactional
public interface BookingRepository extends MongoRepository {
	
	public Booking findByDeparture(String departure);
	

}
