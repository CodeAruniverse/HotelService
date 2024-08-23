package com.main.Hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.Hotel.entities.Hotel;
import com.main.Hotel.service.HotelService;

@RestController
@RequestMapping("/hotel-service")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;

	@PostMapping
	public ResponseEntity<List<Hotel>> saveHotel(@RequestBody List<Hotel> hotels) {
		List<Hotel> saveHotel = this.hotelService.saveHotel(hotels);
		return  ResponseEntity.status(HttpStatus.CREATED).body(saveHotel);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel() {
		List<Hotel> getAllHotel = this.hotelService.getAllHotel();
		return ResponseEntity.ok(getAllHotel);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
		Hotel hotelDetail = this.hotelService.getHotelById(hotelId);
		return ResponseEntity.ok(hotelDetail);
	}
}
