package com.shubham.Nexwent.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.shubham.Nexwent.Entity.Enums.PaymentMethod;
import com.shubham.Nexwent.Entity.Enums.PaymentStatus;
import com.shubham.Nexwent.Entity.Enums.TicketStatus;
import com.shubham.Nexwent.Entity.Enums.TicketType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    private Double price;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    private LocalDateTime issuedAt;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventId")
    @JsonBackReference(value = "ticketReference")
    private Event event;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attendeeId")
    @JsonBackReference(value = "attendeeReference")
    private Attendee attendee;
}
