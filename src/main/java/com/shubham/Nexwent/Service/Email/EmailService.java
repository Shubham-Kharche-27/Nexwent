package com.shubham.Nexwent.Service.Email;

import com.shubham.Nexwent.Dto.EventDto;
import com.shubham.Nexwent.Dto.VenueDto;
import com.shubham.Nexwent.Entity.Enums.EventStatus;
import com.shubham.Nexwent.Entity.Enums.VenueStatus;
import com.shubham.Nexwent.Service.Email.Presets.AttendeeHtmlPresets;
import com.shubham.Nexwent.Service.Email.Presets.EventHtmlPresets;
import com.shubham.Nexwent.Service.Email.Presets.VenueEmailPresets;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@AllArgsConstructor
public class EmailService {

    private JavaMailSender mailSender;

    private AttendeeHtmlPresets attendeeHtmlPresets;

    private EventHtmlPresets eventHtmlPresets;

    private VenueEmailPresets venueEmailPresets;

    public void AttendeeEmail(String to, String attendeeName) {
        String subject = "Welcome to our platform" + attendeeName;
        String body = attendeeHtmlPresets.buildHtmlAttendee(attendeeName);
        emailSender(to, subject, body);
    }

    public void pendingEventEmail(String to, String organizerName) {
        String subject = "Event booking status";
        String body = eventHtmlPresets.buildHtmlEvent(organizerName);
        emailSender(to, subject, body);
    }

    public void eventStatusEmail(String to, EventDto eventDto) {
        String subject = "Event booking status";
        if (eventDto.getEventStatus().equals(EventStatus.Confirmed)) {
            String body = eventHtmlPresets.buildHtmlEventStatusConfirmed(eventDto.getOrganizerName());
            emailSender(to, subject, body);
        }
        if (eventDto.getEventStatus().equals(EventStatus.Not_Confirmed)) {
            String body = eventHtmlPresets.buildHtmlEventStatusNotConfirmed(eventDto.getOrganizerName());
            emailSender(to, subject, body);
        }
    }

    public void pendingVenueEmail(String to, String venueOwnerName) {
        String subject = "Venue booking status";
        String body = venueEmailPresets.buildHtmlEvent(venueOwnerName);
        emailSender(to, subject, body);
    }

    public void venueStatusEmail(String to, VenueDto venueDto) {
        String subject = "Venue booking status";
        if (venueDto.getVenueStatus().equals(VenueStatus.Confirmed)) {
            String body = venueEmailPresets.buildHtmlEventStatusConfirmed(venueDto.getVenueOwnerName());
            emailSender(to, subject, body);
        }
        if (venueDto.getVenueStatus().equals(VenueStatus.Not_Confirmed)) {
            String body = venueEmailPresets.buildHtmlEventStatusNotConfirmed(venueDto.getVenueOwnerName());
            emailSender(to, subject, body);
        }
    }

    public void emailSender(String to, String subject, String body) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);
            mailSender.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }

    }
}
