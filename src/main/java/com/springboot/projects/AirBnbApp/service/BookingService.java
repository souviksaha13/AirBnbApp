package com.springboot.projects.AirBnbApp.service;

import com.springboot.projects.AirBnbApp.dto.BookingDto;
import com.springboot.projects.AirBnbApp.dto.BookingRequest;
import com.springboot.projects.AirBnbApp.dto.GuestDto;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface BookingService {
    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);
}
