package com.shubham.Nexwent.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.shubham.Nexwent.Entity.Enums.EventCategory;
import com.shubham.Nexwent.Entity.Enums.EventStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    private String eventTitle;
    private String eventDesc;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime eventStartDateTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime eventEndDateTime;

    @Enumerated(EnumType.STRING)
    private EventCategory eventCategory;

    private String organizerName;
    private String organizerContact;

    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venueId")
    @JsonBackReference(value = "venueReference")
    private Venue venue;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "eventAttendee",
            joinColumns = @JoinColumn(name = "eventId"),
            inverseJoinColumns = @JoinColumn(name = "attendeeId")
    )
    @JsonBackReference(value = "attendeeEventReference")
    private Set<Attendee> attendees = new HashSet<>();

    @OneToMany(mappedBy = "event",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference(value = "ticketReference")
    private Set<Tickets> tickets = new HashSet<>();

    @PrePersist
    private void createdAt(){
        createdAt = LocalDateTime.now();
    }
}
