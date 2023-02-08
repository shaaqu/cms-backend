package pl.put.cms.server.entities.restaurant.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.put.cms.server.entities.restaurant.MenuPositionPicture;

import java.io.Serializable;

/**
 * A DTO for the {@link MenuPositionPicture} entity
 */

public record MenuPositionPictureDto(String image) implements Serializable {
}