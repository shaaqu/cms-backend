package pl.put.cms.server.entities.cms.dtos;

import lombok.*;
import pl.put.cms.server.entities.cms.NavigationBarButton;

import java.io.Serializable;

/**
 * A DTO for the {@link NavigationBarButton} entity
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NavigationBarButtonDto implements Serializable {
    private Integer id;
    private String content;
    private String url;
}