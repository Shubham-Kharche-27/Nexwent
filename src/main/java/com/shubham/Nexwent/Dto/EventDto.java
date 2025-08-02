package com.shubham.Nexwent.Dto;

import com.shubham.Nexwent.Entity.Attendee;
import com.shubham.Nexwent.Entity.Enums.EventCategory;
import com.shubham.Nexwent.Entity.Enums.EventStatus;
import com.shubham.Nexwent.Entity.Tickets;
import com.shubham.Nexwent.Entity.Venue;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class EventDto {
    private Long eventId;
    private String eventTitle;
    private String eventDesc;
    private LocalDateTime eventStartDateTime;
    private LocalDateTime eventEndDateTime;
    private EventCategory eventCategory;
    private String organizerName;

    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid phone number!")
    private String organizerContact;

    private EventStatus eventStatus;
    private LocalDateTime createdAt;
    private Venue venue;
    private Set<Attendee> attendees = new HashSet<>();
    private Set<Tickets> tickets = new HashSet<>();
}
