package com.main.Hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.Hotel.entities.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, String> {

}
