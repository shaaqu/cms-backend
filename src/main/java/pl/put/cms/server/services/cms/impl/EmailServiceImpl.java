package pl.put.cms.server.services.cms.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;
import pl.put.cms.server.services.cms.EmailService;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired @Qualifier("emailsender")
    private JavaMailSender mailSender;

//    @Autowired
//    public EmailServiceImpl(JavaMailSender mailSender) {
//        this.mailSender = mailSender;
//    }

//    public void sendEmail(ReservationDto reservationDto) throws MessagingException {
//        MimeMessage message = mailSender.createMimeMessage();
//        message.addRecipient(Message.RecipientType.TO,new InternetAddress("pawel.lukaszewicz@student.put.poznan.pl"));
//        message.setSubject("reservation");
//        message.setText(reservationDto.message());
//
//        mailSender.send(message);
//    }

}
