package com.springboot.projects.AirBnbApp.strategy;

import com.springboot.projects.AirBnbApp.entity.Inventory;

import java.math.BigDecimal;

public interface PricingStrategy {

    BigDecimal calculatePrice(Inventory inventory);
}
