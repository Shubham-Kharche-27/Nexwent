package com.shubham.Nexwent.Service.Email.Presets;

public class EventHtmlPresets {
    public String buildHtmlEvent(String organizerName) {
        return """
                <html>
                <body style="font-family: cursive; background-color: #f8f9fa; color: #333; word-spacing: 0.2em; ">
                    <div style="max-width: 600px; margin: auto; background-color: #ffffff; border: 1px solid #ddd; padding: 20px; border-radius: 8px;">
                        <h2 style="color: #FFA500;">⏳ Booking Request Received</h2>
                        <p>Dear <strong>%s</strong>,</p>
                        <p>Thank you for submitting your event booking request. Your request is currently <strong>pending</strong>.</p>
                        <p>Our team will review the details and get back to you shortly. You will receive an update once your booking has been approved or if we need more information.</p>
                        <p style="margin-top: 30px;">Best regards,<br>
                        <strong>Nexwent Team</strong></p>
                    </div>
                </body>
                </html>
                """.formatted(organizerName);
    }

    public String buildHtmlEventStatusConfirmed(String organizerName) {
        return """
                <html>
                <body style="font-family: cursive; background-color: #f4f4f4; color: #333;">
                    <div style="max-width: 600px; margin: auto; background-color: #ffffff; border: 1px solid #ddd; padding: 20px; border-radius: 8px; word-spacing: 0.2em;">
                        <h2 style="color: #28a745;">✅ Booking Confirmed</h2>
                
                        <p>Dear <strong>%s</strong>,</p>
                
                        <p>We are pleased to inform you that your event booking has been <strong>confirmed</strong>.</p>
                
                        <p>We look forward to hosting your event. If you have any questions or need assistance, feel free to reach out.</p>
                
                        <p style="margin-top: 30px;">Best regards,<br>
                        <strong>Nexwent Team</strong></p>
                    </div>
                </body>
                </html>
                """.formatted(organizerName);
    }

    public String buildHtmlEventStatusNotConfirmed(String organizerName) {
        return """
                <html>
                <body style="font-family: cursive; background-color: #f8f9fa; color: #333; word-spacing: 0.2em;">
                    <div style="max-width: 600px; margin: auto; background-color: #ffffff; border: 1px solid #ddd; padding: 20px; border-radius: 8px;">
                        <h2 style="color: #dc3545;">❌ Booking Not Confirmed</h2>
                
                        <p>Dear <strong>%s</strong>,</p>
                
                        <p>We regret to inform you that your event booking request has <strong>not been confirmed</strong> at this time.</p>
                
                        <p>If you have questions or would like to discuss alternative options, please feel free to get in touch with our team.</p>
                
                        <p style="margin-top: 30px;">Best regards,<br>
                        <strong>Nexwent Team</strong></p>
                    </div>
                </body>
                </html>
                """.formatted(organizerName);
    }
}
