package com.shubham.Nexwent.Service.Email.Presets;

public class TicketHtmlPresets {
    public String buildTicketHtmlTemplate(String attendeeName, String eventTitle, String dateAndTime, String venueName, String ticketType, String ticketId, String organizerName) {
        return """
                <html>
                  <style>
                    body {
                      font-family: cursive;
                      background-color: #f4f4f4;
                      word-spacing: 0.2em;
                      margin: 0;
                      padding: 0;
                    }
                    .email-container {
                      max-width: 600px;
                      margin: 0 auto;
                      background-color: #ffffff;
                      border: 1px solid #ddd;
                      border-radius: 8px;
                      overflow: hidden;
                    }
                    .header {
                      background-color: #ff4e7a;
                      color: white;
                      text-align: center;
                      padding: 20px;
                      font-family:system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
                    }
                    .content {
                      padding: 20px;
                      color: #333333;
                    }
                    .ticket-status {
                      padding: 10px;
                      margin: 15px 0;
                      background-color: #e0f7e9;
                      color: #007e33;
                      border-left: 5px solid #00c851;
                      font-weight: bold;
                    }
                    .ticket-info {
                      margin: 20px 0;
                    }
                    .ticket-info table {
                      width: 100%%;
                      border-collapse: collapse;
                    }
                    .ticket-info td {
                      padding: 8px 0;
                    }
                  </style>
                <body>
                  <div class="email-container">
                    <div class="header">
                      <h1>🎫 Your Event Ticket</h1>
                    </div>
                    <div class="content">
                      <p>Hello <strong>%s</strong>,</p>
                      <p>Thank you for booking your ticket with us. Here are your event details:</p>
                     \s
                      <div class="ticket-status">✅ Ticket Status: <strong>Confirmed</strong></div>
                
                      <div class="ticket-info">
                        <table>
                          <tr>
                            <td><strong>Event:</strong></td>
                            <td>%s</td>
                          </tr>
                          <tr>
                            <td><strong>Date & Time:</strong></td>
                            <td>%s</td>
                          </tr>
                          <tr>
                            <td><strong>Venue:</strong></td>
                            <td>%s</td>
                          </tr>
                            <td><strong>Ticket Type:</strong></td>
                            <td>%s</td>
                          </tr>
                          <tr>
                            <td><strong>Booking ID:</strong></td>
                            <td>%s</td>
                          </tr>
                        </table>
                      </div>
                
                      <p><b>Note: </b>Please arrive 30 minutes early and bring a valid ID along with this ticket.</p>
                
                      <p><i>We look forward to seeing you!</i></p>
                      <div>
                        <p><b>- %s </b>(Event organizer)</p>
                      </div>
                    </div>
                  </div>
                </body>
                </html>
                """.formatted(attendeeName, eventTitle, dateAndTime, venueName, ticketType, ticketId, organizerName);
    }
}
