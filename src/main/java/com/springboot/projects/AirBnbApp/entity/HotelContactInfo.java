package com.springboot.projects.AirBnbApp.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class HotelContactInfo {
    // the idea to create a seperate class is to maintain modularity and code reusability
    private String address;
    private String phoneNumber;
    private String email;
    private String location;
}
