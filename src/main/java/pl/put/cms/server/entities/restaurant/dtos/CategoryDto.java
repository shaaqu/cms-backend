package pl.put.cms.server.entities.restaurant.dtos;

import lombok.*;
import pl.put.cms.server.entities.restaurant.Category;

import java.io.Serializable;

/**
 * A DTO for the {@link Category} entity
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto implements Serializable {
    private Integer id;
    private String category;
}