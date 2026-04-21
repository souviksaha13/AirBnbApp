package com.springboot.projects.AirBnbApp.repository;

import com.springboot.projects.AirBnbApp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
