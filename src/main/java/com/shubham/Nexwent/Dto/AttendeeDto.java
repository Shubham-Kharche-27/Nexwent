package com.shubham.Nexwent.Dto;

import com.shubham.Nexwent.Entity.Enums.Gender;
import com.shubham.Nexwent.Entity.Event;
import com.shubham.Nexwent.Entity.Tickets;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class AttendeeDto {
    private Long attendeeId;
    private String attendeeName;

    @Email(message = "Invalid email Id!")
    private String email;

    @Pattern(regexp = "^[6-9]\\d{9}$")
    private String phone;

    private Gender gender;
    private int age;
    private Set<Event> events = new HashSet<>();
    private Tickets tickets;
}
