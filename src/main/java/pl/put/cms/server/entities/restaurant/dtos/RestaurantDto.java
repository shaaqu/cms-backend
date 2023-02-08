package pl.put.cms.server.entities.restaurant.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.put.cms.server.entities.restaurant.Restaurant;

import java.io.Serializable;

/**
 * A DTO for the {@link Restaurant} entity
 */

public record RestaurantDto(Integer id, String name, String cuisine, String address,
                            String openCloseHours) implements Serializable {
}