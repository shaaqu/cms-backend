package pl.put.cms.server.entities.restaurant.dtos;

import lombok.Getter;

import java.io.Serializable;

@Getter
public record ContactForm(String email, String message) implements Serializable {
}
