package com.springboot.projects.AirBnbApp.service.Impl;

import com.springboot.projects.AirBnbApp.dto.BookingDto;
import com.springboot.projects.AirBnbApp.dto.BookingRequest;
import com.springboot.projects.AirBnbApp.entity.Hotel;
import com.springboot.projects.AirBnbApp.entity.Inventory;
import com.springboot.projects.AirBnbApp.entity.Room;
import com.springboot.projects.AirBnbApp.exception.ResourceNotFoundException;
import com.springboot.projects.AirBnbApp.repository.BookingRepository;
import com.springboot.projects.AirBnbApp.repository.HotelRepository;
import com.springboot.projects.AirBnbApp.repository.InventoryRepository;
import com.springboot.projects.AirBnbApp.repository.RoomRepository;
import com.springboot.projects.AirBnbApp.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final InventoryRepository inventoryRepository;

    @Override
    @Transactional
    public BookingDto initialiseBooking(BookingRequest bookingRequest) {

        Hotel hotel = hotelRepository.findById(bookingRequest.getHotelId()).orElseThrow(
                () -> new ResourceNotFoundException("Hotel not found with id: " + bookingRequest.getHotelId())
        );

        Room room = roomRepository.findById(bookingRequest.getRoomId()).orElseThrow(
                () -> new ResourceNotFoundException("Room not found with id: " + bookingRequest.getRoomId())
        );

        List<Inventory> inventoryList = inventoryRepository.findAndLockAvailableInventory(room.getId(), bookingRequest.getCheckinDate(), bookingRequest.getCheckoutDate(), bookingRequest.getRoomsCount());

        return null;
    }
}
