package com.shubham.Nexwent.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.shubham.Nexwent.Entity.Enums.Gender;
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
public class Attendee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendeeId;
    private String attendeeName;
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int age;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime registeredAt;

    @ManyToMany(mappedBy = "attendees",cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER)
    @JsonManagedReference(value = "attendeeEventReference")
    private Set<Event> events = new HashSet<>();

    @OneToOne(mappedBy = "attendee",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference(value = "attendeeTicketsReference")
    private Tickets tickets;

    @PrePersist
    private void createdAt(){
        registeredAt = LocalDateTime.now();
    }
}
