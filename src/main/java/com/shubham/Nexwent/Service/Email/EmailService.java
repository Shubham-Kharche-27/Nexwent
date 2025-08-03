package com.shubham.Nexwent.Service.Email;

import com.shubham.Nexwent.Service.Email.Presets.AttendeeHtmlPresets;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@AllArgsConstructor
public class EmailService {

    private JavaMailSender mailSender;

    private AttendeeHtmlPresets attendeeHtmlPresets;

    public void AttendeeEmail(String to,String attendeeName){
        String subject = "Welcome to our platform"+attendeeName;
        String body = attendeeHtmlPresets.buildHtmlAttendee(attendeeName);
        emailSender(to,subject,body);
    }

    public void emailSender(String to,String subject,String body){
        try{
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body,true);
            mailSender.send(message);
        }catch (MessagingException ex){
            ex.printStackTrace();
        }

    }
}
