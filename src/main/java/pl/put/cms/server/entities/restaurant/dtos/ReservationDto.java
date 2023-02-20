package pl.put.cms.server.entities.restaurant.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto implements Serializable {

    private String mail;
    private Date date;
    private String name;
    private String phoneNumber;
    private int numberOfGuests;
    private String massage;

}
