package com.springboot.projects.AirBnbApp.service;

import com.springboot.projects.AirBnbApp.dto.BookingDto;
import com.springboot.projects.AirBnbApp.dto.BookingRequest;
import org.jspecify.annotations.Nullable;

public interface BookingService {
    BookingDto initialiseBooking(BookingRequest bookingRequest);
}
