package pl.put.cms.server.entities.cms.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.put.cms.server.entities.cms.NavigationBarButton;

import java.io.Serializable;

/**
 * A DTO for the {@link NavigationBarButton} entity
 */

public record NavigationBarButtonDto(String content, String url) implements Serializable {
}