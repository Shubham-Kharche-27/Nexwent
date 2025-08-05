package com.shubham.Nexwent.Service.Email.Presets;

import org.springframework.stereotype.Component;

@Component
public class AttendeeHtmlPresets {

    public String buildHtmlAttendee(String attendeeName){
        return """
                <html>
                    <body>
                        <style>
                            *{
                                font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
                                word-spacing: 0.2em;
                                letter-spacing: 0.1em;
                            }
                            h1{
                                color: orange;
                            }
                        </style>
                        <h1>Welcome, %s 🎉</h1>
                        <p>Thank you for registrating on our platform, Now you can view events and booked tickets of the events.</p>
                        <p>If you have any questions, feel free to contact our support team.</p>
                        <p>- Team Nexwent</p>
                    </body>
                </html>
                """.formatted(attendeeName);
    }
}
