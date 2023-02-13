package pl.put.cms.server.entities.cms.dtos;

import java.io.Serializable;

public record PostDto(String title, String text, String image) implements Serializable {
}
