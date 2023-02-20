package pl.put.cms.server.entities.cms.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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