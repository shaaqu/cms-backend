package pl.put.cms.server.entities.restaurant.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.put.cms.server.entities.restaurant.MenuPosition;

import java.io.Serializable;

/**
 * A DTO for the {@link MenuPosition} entity
 */
@Getter @Setter
public record MenuPositionDto(Integer id, String name, String description, double price, String category,
                              boolean isShownOnMainPage) implements Serializable {
}