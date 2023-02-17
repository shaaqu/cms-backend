package pl.put.cms.server.entities.restaurant.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.put.cms.server.entities.restaurant.MenuPosition;

import java.io.Serializable;

/**
 * A DTO for the {@link MenuPosition} entity
 */
public record MenuPositionDto(String name,
                              String description,
                              double price,
                              String category
    ) implements Serializable { }