package com.springboot.projects.AirBnbApp.service.Impl;

import com.springboot.projects.AirBnbApp.dto.RoomDto;
import com.springboot.projects.AirBnbApp.entity.Hotel;
import com.springboot.projects.AirBnbApp.entity.Room;
import com.springboot.projects.AirBnbApp.exception.ResourceNotFoundException;
import com.springboot.projects.AirBnbApp.repository.HotelRepository;
import com.springboot.projects.AirBnbApp.repository.RoomRepository;
import com.springboot.projects.AirBnbApp.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    public RoomDto createNewRoom(Long hotelId, RoomDto roomDto) {
        log.info("Creating a new room in hotel with ID: {}", hotelId);
        Room newRoom = modelMapper.map(roomDto, Room.class);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("No Hotel found with id: " + hotelId));
        newRoom.setHotel(hotel);
        newRoom = roomRepository.save(newRoom);
        // TODO: Create inventory as soon as room is created and if hotel is active
        return modelMapper.map(newRoom, RoomDto.class);
    }

    @Override
    public List<RoomDto> getAllRoomsInHotel(Long hotelId) {
        log.info("Getting all rooms in hotel with ID: {}", hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("No Hotel found with id: " + hotelId));

        return hotel.getRooms()
                .stream()
                .map((element) -> modelMapper.map(element, RoomDto.class)).collect(Collectors.toList());
    }

    @Override
    public RoomDto getRoomById(Long roomId) {
        log.info("Getting the room with ID: {}", roomId);
        Room room = roomRepository
                .findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("No Room found with id: " + roomId));

        return modelMapper.map(room, RoomDto.class);
    }

    @Override
    public void deleteRoomById(Long roomId) {
        log.info("Deleting the room with ID: {}", roomId);
        boolean exists = roomRepository.existsById(roomId);
        if(!exists) throw new ResourceNotFoundException("No Room found with id: " + roomId);

        roomRepository.deleteById(roomId);
        // TODO: WHen the room is deleted then the inventory of that room also has to be deleted
    }
}
