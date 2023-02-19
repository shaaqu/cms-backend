package pl.put.cms.server.entities.restaurant.dtos;

import lombok.*;
import pl.put.cms.server.entities.restaurant.MenuPositionPicture;

import java.io.Serializable;

/**
 * A DTO for the {@link MenuPositionPicture} entity
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuPositionPictureDto implements Serializable {
    private Integer id;
    private String image;
}