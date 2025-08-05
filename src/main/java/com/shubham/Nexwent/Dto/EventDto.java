package com.shubham.Nexwent.Dto;

import com.shubham.Nexwent.Entity.Enums.EventCategory;
import com.shubham.Nexwent.Entity.Enums.EventStatus;
import jakarta.validation.constraints.Email;
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

    @Email(message = "Invalid email Id")
    private String organizerEmail;

    private EventStatus eventStatus = EventStatus.Pending;
    private LocalDateTime createdAt;
    private Long venueId;
    private Set<AttendeeDto> attendees = new HashSet<>();
    private Set<TicketsDto> tickets = new HashSet<>();
}
