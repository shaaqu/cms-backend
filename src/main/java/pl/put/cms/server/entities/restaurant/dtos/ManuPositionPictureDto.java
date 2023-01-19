package pl.put.cms.server.entities.restaurant.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.put.cms.server.entities.restaurant.ManuPositionPicture;

import java.io.Serializable;

/**
 * A DTO for the {@link ManuPositionPicture} entity
 */
@AllArgsConstructor
@Getter
public record ManuPositionPictureDto(String image) implements Serializable {
}