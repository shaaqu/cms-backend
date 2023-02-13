package pl.put.cms.server.entities.cms.dtos;

import java.util.List;

public record NavigationBarDto(String logo, String name, List<NavigationBarButtonDto> buttons) {
}
