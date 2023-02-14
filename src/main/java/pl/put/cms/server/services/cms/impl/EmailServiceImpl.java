package pl.put.cms.server.services.cms.impl;

import jakarta.mail.Address;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import pl.put.cms.server.entities.cms.dtos.ReservationDto;
import pl.put.cms.server.services.cms.EmailService;

@Component
public class EmailServiceImpl implements EmailService {


    private JavaMailSender mailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(ReservationDto reservationDto) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        message.setFrom(reservationDto.email());
        message.setRecipients(Message.RecipientType.TO,"pawel.lukaszewicz@student.put.poznan.pl");
        message.setSubject("Reservation");
        message.setText(reservationDto.message());
        mailSender.send(message);
    }

}
