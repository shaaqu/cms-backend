package pl.put.cms.server.entities.cms.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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