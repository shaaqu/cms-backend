package pl.put.cms.server.entities.cms.dtos;

import lombok.*;
import pl.put.cms.server.entities.cms.NavigationBar;

import java.io.Serializable;

/**
 * A DTO for the {@link NavigationBar} entity
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NavigationBarDto implements Serializable {
    private Integer id;
    private String logo;
    private String name;
}