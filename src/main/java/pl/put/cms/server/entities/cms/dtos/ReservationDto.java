package pl.put.cms.server.entities.cms.dtos;

import java.util.Date;

public record ReservationDto(Date date, String timeTables, int numberOfGuest, String name, String email, String phoneNumber, String message) {
}
