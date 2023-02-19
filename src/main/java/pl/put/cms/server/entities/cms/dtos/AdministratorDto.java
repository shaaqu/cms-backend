package pl.put.cms.server.entities.cms.dtos;

import lombok.*;
import pl.put.cms.server.entities.cms.Administrator;

import java.io.Serializable;

/**
 * A DTO for the {@link Administrator} entity
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdministratorDto implements Serializable {
    private String login;
    private char[] password;
}