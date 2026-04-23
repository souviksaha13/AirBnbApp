package com.springboot.projects.AirBnbApp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequest {
    private Long hotelId;
    private Long roomId;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private Integer roomsCount;
}
