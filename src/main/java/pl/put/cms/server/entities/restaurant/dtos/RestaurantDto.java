package pl.put.cms.server.entities.restaurant.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.put.cms.server.entities.restaurant.Restaurant;

import java.io.Serializable;

/**
 * A DTO for the {@link Restaurant} entity
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto implements Serializable {
    private Integer id;
    private String name;
    private String cuisine;
}