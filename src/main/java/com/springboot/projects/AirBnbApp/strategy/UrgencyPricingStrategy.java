package com.springboot.projects.AirBnbApp.strategy;

import com.springboot.projects.AirBnbApp.entity.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UrgencyPricingStrategy implements PricingStrategy{

    private final PricingStrategy wrapped;

    @Override
    public BigDecimal calculatePrice(Inventory inventory) {
        BigDecimal price = wrapped.calculatePrice(inventory);

        LocalDate today = LocalDate.now();
        boolean isUrgent = !inventory.getDate().isBefore(today) && inventory.getDate().isBefore(today.plusDays(7));

        if(isUrgent) {
            price = price.multiply(BigDecimal.valueOf(1.15));
        }

        return price;
    }
}
