package pl.put.cms.server.services.cms;

import pl.put.cms.server.entities.cms.dtos.ReservationDto;

public interface EmailService {

    void sendEmail(ReservationDto reservationDto);

}
