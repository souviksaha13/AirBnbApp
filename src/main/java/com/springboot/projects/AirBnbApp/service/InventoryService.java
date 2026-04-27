package com.springboot.projects.AirBnbApp.service;

import com.springboot.projects.AirBnbApp.dto.HotelDto;
import com.springboot.projects.AirBnbApp.dto.HotelPriceDto;
import com.springboot.projects.AirBnbApp.dto.HotelSearchRequest;
import com.springboot.projects.AirBnbApp.entity.Room;
import org.springframework.data.domain.Page;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelDto> searchHotels(HotelSearchRequest hotelSearchRequest);

    Page<HotelPriceDto> searchHotels2(HotelSearchRequest hotelSearchRequest);
}
