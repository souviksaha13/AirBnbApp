package com.springboot.projects.AirBnbApp.service.Impl;

import com.springboot.projects.AirBnbApp.dto.HotelDto;
import com.springboot.projects.AirBnbApp.entity.Hotel;
import com.springboot.projects.AirBnbApp.entity.Room;
import com.springboot.projects.AirBnbApp.exception.ResourceNotFoundException;
import com.springboot.projects.AirBnbApp.repository.HotelRepository;
import com.springboot.projects.AirBnbApp.repository.RoomRepository;
import com.springboot.projects.AirBnbApp.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;
    private final InventoryServiceImpl inventoryService;
    private final RoomRepository roomRepository;

    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        log.info("Creating a new Hotel with name: {}", hotelDto.getName());

        Hotel newHotel = modelMapper.map(hotelDto, Hotel.class);
        // initially the hotel will remain inactive in the platform. The owner has to manually activate it
        newHotel.setActive(false);

        Hotel hotel = hotelRepository.save(newHotel);
        log.info("Created a new Hotel with id: {}", hotel.getId());
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        log.info("Getting a Hotel with id: {}", id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Hotel found with id: " + id));
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto updateHotelById(Long id, HotelDto hotelDto) {
        log.info("Updating Hotel with id: {}", id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Hotel found with id: " + id));

        modelMapper.map(hotelDto, hotel);
        hotel.setId(id);
        hotel.setActive(false);
        hotel = hotelRepository.save(hotel);
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    @Transactional
    public void deleteHotelById(Long id) {
        log.info("Deleting a Hotel with id: {}", id);
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: " + id));

        // first delete the inventories, then delete the rooms -> then finally we can delete the hotel
        for(Room room: hotel.getRooms()) {
            // ordering matters a lot here -> inventory has room field -> can't delete room before deleting the inventory. Same with room and hotel
            inventoryService.deleteAllInventories(room);
            roomRepository.deleteById(room.getId());
        }

        hotelRepository.deleteById(id);

    }

    @Override
    public void activateHotel(Long id) {
        log.info("Activating the Hotel with id: {}", id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Hotel found with id: " + id));

        hotel.setActive(true);
        // TODO: Assuming we are doing it only once. Need to solve it later
        for(Room room : hotel.getRooms()) {
            inventoryService.initializeRoomForAYear(room);
        }
        hotelRepository.save(hotel);
    }
}
