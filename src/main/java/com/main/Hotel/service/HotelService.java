package com.main.Hotel.service;

import java.util.List;

import com.main.Hotel.entities.Hotel;

public interface HotelService {

	//save a list of hotel details
	List<Hotel> saveHotel(List<Hotel> hotel);
	
	//get the list of hotel details
	List<Hotel> getAllHotel();
	
	//get a hotel details by id
	Hotel getHotelById(String hotelId);
}
