package com.bookmyevent.emailservice.service;

import com.bookmyevent.emailservice.dto.BookingDTO;
import com.bookmyevent.emailservice.dto.TicketDTO;
import com.bookmyevent.emailservice.util.EmailServiceConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);
        javaMailSender.send(simpleMailMessage);
    }

    @KafkaListener(topics = "${email.topic}", groupId = "${email.groupId}")
    public void consumeBooking(BookingDTO bookingDTO) {
        try {
            String subject = EmailServiceConstants.emailSubject;
            String userName = bookingDTO.getUserName();
            String eventName = bookingDTO.getEventName();
            String venueName = bookingDTO.getVenueName();
            String cityName = bookingDTO.getCityName() != null ? bookingDTO.getCityName() : "";

            String ticketInfo;
            if (bookingDTO.getSeatNumbers() != null && !bookingDTO.getSeatNumbers().isEmpty()) {
                // INDOOR EVENT - Show seat numbers
                ticketInfo = "Seats: " + String.join(", ", bookingDTO.getSeatNumbers());
            } else {
                // OUTDOOR EVENT - Show ticket breakdown
                ticketInfo = buildTicketSummary(bookingDTO.getTickets());
            }

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.US);
            String formattedDate = bookingDTO.getShowTime() != null
                    ? bookingDTO.getShowTime().format(dateFormatter)
                    : bookingDTO.getBookingTime().format(dateFormatter);
            String showTime = bookingDTO.getShowTime() != null
                    ? bookingDTO.getShowTime().format(timeFormatter)
                    : "TBD";

            String body = String.format(EmailServiceConstants.emailFormat,
                    userName, eventName, venueName, cityName, formattedDate, showTime,
                    ticketInfo, bookingDTO.getBookingReferenceId()
            );

            sendEmail(bookingDTO.getUserEmail(), subject, body);
            System.out.println("✅ Email sent successfully to: " + bookingDTO.getUserEmail());

        } catch (Exception e) {
            System.err.println("❌ Failed to send email: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String buildTicketSummary(List<TicketDTO> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            return "General Admission";
        }

        // Group tickets by category and count
        Map<String, Long> ticketCounts = tickets.stream()
                .collect(Collectors.groupingBy(
                        ticket -> ticket.getTicketCategoryName() != null
                                ? ticket.getTicketCategoryName()
                                : "General",
                        Collectors.counting()
                ));

        // Format: "2x VIP Pass, 3x General Entry"
        return ticketCounts.entrySet().stream()
                .map(entry -> entry.getValue() + "x " + entry.getKey())
                .collect(Collectors.joining(", "));
    }

}
