package com.shubham.Nexwent.Dto;

import com.shubham.Nexwent.Entity.Attendee;
import com.shubham.Nexwent.Entity.Enums.PaymentMethod;
import com.shubham.Nexwent.Entity.Enums.PaymentStatus;
import com.shubham.Nexwent.Entity.Enums.TicketStatus;
import com.shubham.Nexwent.Entity.Enums.TicketType;
import com.shubham.Nexwent.Entity.Event;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketsDto {
    private Long ticketId;
    private TicketType ticketType;
    private Double price;
    private TicketStatus ticketStatus;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;
    private Long eventId;
    private Long attendeeId;
}
