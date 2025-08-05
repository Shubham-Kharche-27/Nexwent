package com.shubham.Nexwent.Service.Email.Presets;

import org.springframework.stereotype.Component;

@Component
public class VenueEmailPresets {

    public String buildHtmlEvent(String venueOwnerName) {
        return """
                <html>
                <body style="font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif; background-color: #f4f4f4; color: #333;word-spacing: 0.2em;">
                    <div style="max-width: 600px; margin: auto; background-color: #fff; border: 1px solid #ddd; padding: 20px; border-radius: 8px;">
                        <h2 style="color: #FFA500;">⏳ Venue Registration Pending</h2>
                        <p>Dear <strong>%s</strong>,</p>
                        <p>We have received your venue registration request. It is currently <strong>pending review</strong> by our team.</p>
                        <p>You will be notified once the review is complete. Thank you for your patience.</p>
                        <p style="margin-top: 30px;">Best regards,<br>
                        <strong>Nexwent Team</strong></p>
                    </div>
                </body>
                </html>
                """.formatted(venueOwnerName);
    }

    public String buildHtmlEventStatusConfirmed(String venueOwnerName) {
        return """
                <html>
                <body style="font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;word-spacing: 0.2em; background-color: #f4f4f4; color: #333;">
                    <div style="max-width: 600px; margin: auto; background-color: #fff; border: 1px solid #ddd; padding: 20px; border-radius: 8px;">
                        <h2 style="color: #28a745;">✅ Venue Registration Approved</h2>
                        <p>Dear <strong>%s</strong>,</p>
                        <p>Great news! Your venue registration has been <strong>successfully approved</strong> and is now live on our platform.</p>
                        <p>You're now ready to receive booking inquiries from event organizers.</p>
                        <p style="margin-top: 30px;">Best regards,<br>
                        <strong>Nexwent Team</strong></p>
                    </div>
                </body>
                </html>
                """.formatted(venueOwnerName);
    }

    public String buildHtmlEventStatusNotConfirmed(String venueOwnerName) {
        return """
                <html>
                <body style="font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;word-spacing: 0.2em; background-color: #f4f4f4; color: #333;">
                    <div style="max-width: 600px; margin: auto; background-color: #fff; border: 1px solid #ddd; padding: 20px; border-radius: 8px;">
                        <h2 style="color: #dc3545;">❌ Venue Registration Not Approved</h2>                
                        <p>Dear <strong>%s</strong>,</p>                
                        <p>We regret to inform you that your venue registration has <strong>not been approved</strong> at this time.</p>                
                        <p>If you would like to update your submission or have any questions, please contact our support team.</p>                
                        <p style="margin-top: 30px;">Best regards,<br>
                        <strong>Nexwent Team</strong></p>
                    </div>
                </body>
                </html>
                """.formatted(venueOwnerName);
    }
}
