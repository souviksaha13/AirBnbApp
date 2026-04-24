package com.springboot.projects.AirBnbApp.dto;

import com.springboot.projects.AirBnbApp.entity.Hotel;
import com.springboot.projects.AirBnbApp.entity.Room;
import com.springboot.projects.AirBnbApp.entity.User;
import com.springboot.projects.AirBnbApp.entity.enums.BookingStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class BookingDto {
    private Long id;
    private Integer roomsCount;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private BookingStatus bookingStatus;
    private Set<GuestDto> guests;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
