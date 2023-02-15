package pl.put.cms.server.services.cms;


import pl.put.cms.server.entities.cms.dtos.ReservationDto;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface EmailService {

    void sendEmail(ReservationDto reservationDto) throws MessagingException;

}
