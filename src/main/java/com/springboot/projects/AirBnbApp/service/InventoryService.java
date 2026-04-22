package com.springboot.projects.AirBnbApp.service;

import com.springboot.projects.AirBnbApp.dto.HotelDto;
import com.springboot.projects.AirBnbApp.dto.HotelSearchRequest;
import com.springboot.projects.AirBnbApp.entity.Room;
import org.springframework.data.domain.Page;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteFutureInventories(Room room);

    Page<HotelDto> searchHotels(HotelSearchRequest hotelSearchRequest);
}
