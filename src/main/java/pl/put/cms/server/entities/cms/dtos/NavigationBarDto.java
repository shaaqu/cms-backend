package pl.put.cms.server.entities.cms.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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