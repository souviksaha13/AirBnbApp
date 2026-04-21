package com.springboot.projects.AirBnbApp.repository;

import com.springboot.projects.AirBnbApp.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
