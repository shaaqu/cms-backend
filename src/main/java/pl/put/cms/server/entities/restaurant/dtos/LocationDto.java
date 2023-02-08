package pl.put.cms.server.entities.restaurant.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;


public record LocationDto(String address,
                          String openCloseHours) implements Serializable {
}
