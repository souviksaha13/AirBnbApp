package com.springboot.projects.AirBnbApp.service;

import com.springboot.projects.AirBnbApp.repository.HotelMinPriceRepository;
import com.springboot.projects.AirBnbApp.repository.HotelRepository;
import com.springboot.projects.AirBnbApp.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PricingUpdateService {

    private final HotelRepository hotelRepository;
    private final InventoryRepository inventoryRepository;
    private final HotelMinPriceRepository hotelMinPriceRepository;

    // Scheduler to update the inventory and HotelMinPrice every hour


}
