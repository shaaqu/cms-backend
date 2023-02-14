package pl.put.cms.server.services.cms.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import pl.put.cms.server.entities.cms.dtos.ReservationDto;
import pl.put.cms.server.services.cms.EmailService;

public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(ReservationDto reservationDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(reservationDto.email());
        message.setTo("pawel.lukaszewicz@student.put.poznan.pl");
        message.setSubject("Reservation");
        message.setText(reservationDto.message());
        javaMailSender.send(message);
    }
}
