package com.springboot.projects.AirBnbApp.service;

import com.springboot.projects.AirBnbApp.entity.Room;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);
}
