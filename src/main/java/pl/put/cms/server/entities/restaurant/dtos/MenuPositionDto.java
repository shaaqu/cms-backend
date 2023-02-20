package pl.put.cms.server.entities.restaurant.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.put.cms.server.entities.restaurant.MenuPosition;

import java.io.Serializable;

/**
 * A DTO for the {@link MenuPosition} entity
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuPositionDto implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private double price;
}