package com.shubham.Nexwent.Dto;

import com.shubham.Nexwent.Entity.Event;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class VenueDto {
    private Long venueId;
    private String venueName;
    private String venueAddress;
    private String City;
    private String State;
    private int Zipcode;
    private String country;
    private String venueCapacity;
    private String parkingAvailable;

    @Email(message = "Invalid email Id!")
    private String contactEmail;

    @Pattern(regexp = "^[6-9]\\d{9}$")
    private String contactPhone;

    private Set<Event> events = new HashSet<>();
}
