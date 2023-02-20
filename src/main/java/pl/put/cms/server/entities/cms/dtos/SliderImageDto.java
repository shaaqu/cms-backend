package pl.put.cms.server.entities.cms.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.put.cms.server.entities.cms.SliderImage;

import java.io.Serializable;

/**
 * A DTO for the {@link SliderImage} entity
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SliderImageDto implements Serializable {
    private Long id;
    private String text;
    private String image;
}