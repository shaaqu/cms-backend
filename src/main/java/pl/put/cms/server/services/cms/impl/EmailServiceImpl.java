package pl.put.cms.server.services.cms.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.put.cms.server.entities.restaurant.Reservation;
import pl.put.cms.server.entities.restaurant.dtos.ReservationDto;
import pl.put.cms.server.repositories.restaurant.ReservationRepository;
import pl.put.cms.server.services.cms.EmailService;

import javax.mail.MessagingException;

@Service
public class EmailServiceImpl implements EmailService {

    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmailServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
        this.modelMapper = new ModelMapper();
    }

    public void sendEmail(ReservationDto reservationDto) {
        reservationRepository.save(modelMapper.map(reservationDto, Reservation.class));
    }

}
