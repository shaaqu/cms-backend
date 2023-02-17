package pl.put.cms.server.entities.restaurant.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * A DTO for the {@link pl.put.cms.server.entities.restaurant.Category} entity
 */
public record CategoryDto(Integer id, String category) implements Serializable {
}