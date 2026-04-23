package com.springboot.projects.AirBnbApp.repository;

import com.springboot.projects.AirBnbApp.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
