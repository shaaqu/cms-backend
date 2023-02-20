package pl.put.cms.server.entities.restaurant.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.put.cms.server.entities.restaurant.RestaurantLocation;

import java.io.Serializable;

/**
 * A DTO for the {@link RestaurantLocation} entity
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantLocationDto implements Serializable {
    private Integer id;
    private String address;
    private String openCloseHours;
}