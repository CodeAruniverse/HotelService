package com.main.Hotel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.Hotel.entities.Hotel;
import com.main.Hotel.exception.ResourceNotFoundException;
import com.main.Hotel.repo.HotelRepo;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public List<Hotel> saveHotel(List<Hotel> hotels) {
		List<Hotel> hotelRows = new ArrayList<>();
		
		for(Hotel hotel : hotels) {
			String userId = UUID.randomUUID().toString();
			hotel.setId(userId);
		}
		
		hotelRows = this.hotelRepo.saveAll(hotels);
		return hotelRows;
	}

	@Override
	public List<Hotel> getAllHotel() {
		return this.hotelRepo.findAll();
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		return this.hotelRepo.findById(hotelId).orElseThrow( () -> new ResourceNotFoundException("Specific hotel is not present"));
	}

}
