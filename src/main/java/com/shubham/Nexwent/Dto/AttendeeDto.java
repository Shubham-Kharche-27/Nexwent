package com.shubham.Nexwent.Dto;

import com.shubham.Nexwent.Entity.Enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

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

}
