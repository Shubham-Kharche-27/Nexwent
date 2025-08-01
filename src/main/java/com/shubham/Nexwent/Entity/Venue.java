package com.shubham.Nexwent.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long venueId;
    private String venueName;
    private String venueAddress;
    private String City;
    private String State;
    private int Zipcode;
    private String country;
    private String venueCapacity;
    private String parkingAvailable;
    private String contactEmail;
    private String contactPhone;

    @OneToMany(mappedBy = "venue",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference(value = "venueReference")
    private Set<Event> events = new HashSet<>();
}
