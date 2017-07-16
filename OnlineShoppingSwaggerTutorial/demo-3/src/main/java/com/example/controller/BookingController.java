package com.example.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Booking;
import com.example.repository.BookingRepository;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	BookingRepository bookingRepository;

	@RequestMapping("/create")
	public Map<String, Object> create(Booking booking) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		booking.setTravelDate(new Date());
		booking = (Booking) bookingRepository.save(booking);
		dataMap.put("status", "success");
		dataMap.put("message", "Data inserted successfully");
		dataMap.put("booking", booking);

		return dataMap;
	}

	@RequestMapping("/read")
	public Map<String, Object> read(@RequestParam String bookingId) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Booking booking = (Booking) bookingRepository.findOne(bookingId);
		dataMap.put("status", "success");
		dataMap.put("message", "Booking found successfully");
		dataMap.put("booking", booking);

		return dataMap;
	}

	@RequestMapping("/update")
	public Map<String, Object> update(@RequestParam String bookingId, @RequestParam String passengerName) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Booking booking = (Booking) bookingRepository.findOne(bookingId);
		booking.setPassengerName(passengerName);
		booking = (Booking) bookingRepository.save(booking);
		dataMap.put("status", "success");
		dataMap.put("message", "Booking updated successfully");
		dataMap.put("booking", booking);

		return dataMap;

	}

	/**
	 * GET /delete --> Delete a booking from the database.
	 */
	@RequestMapping("/delete")
	public Map<String, Object> delete(@RequestParam String bookingId) {
		bookingRepository.delete(bookingId);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Booking deleted successfully");
		dataMap.put("status", "1");
		return dataMap;
	}

	@RequestMapping("/read-all")
	public Map<String, Object> readAll() {
		List<Booking> bookings = bookingRepository.findAll();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Booking found successfully");
		dataMap.put("totalBooking", bookings.size());
		dataMap.put("status", "1");
		dataMap.put("bookings", bookings);
		return dataMap;

	}

}
