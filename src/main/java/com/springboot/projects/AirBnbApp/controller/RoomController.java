package com.springboot.projects.AirBnbApp.controller;

import com.springboot.projects.AirBnbApp.dto.RoomDto;
import com.springboot.projects.AirBnbApp.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/hotels/{hotelId}/rooms")
@RequiredArgsConstructor
@Slf4j
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<RoomDto> createNewRoom(@PathVariable Long hotelId, @RequestBody RoomDto roomDto) {
        RoomDto room = roomService.createNewRoom(hotelId, roomDto);
        return new ResponseEntity<>(room, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RoomDto>> getAllRoomsInHotel(@PathVariable Long hotelId) {
        List<RoomDto> roomDtoList = roomService.getAllRoomsInHotel(hotelId);
        return new ResponseEntity<>(roomDtoList, HttpStatus.OK);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<RoomDto> getRoomById(@PathVariable Long roomId) {
        RoomDto roomDto = roomService.getRoomById(roomId);
        return ResponseEntity.ok(roomDto);
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteRoomById(@PathVariable Long roomId, @PathVariable Long hotelId) {
        roomService.deleteRoomById(roomId, hotelId);
        return ResponseEntity.noContent().build();
    }
}
