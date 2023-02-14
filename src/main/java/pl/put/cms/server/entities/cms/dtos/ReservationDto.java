package pl.put.cms.server.entities.cms.dtos;

import java.util.Date;

public record ReservationDto(Date date, double duration, int numberOfGuest, String name, String email, String phoneNumber, String message) {
}
