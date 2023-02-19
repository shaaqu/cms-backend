package pl.put.cms.server.entities.restaurant.dtos;

import lombok.*;
import pl.put.cms.server.entities.restaurant.ContactAddress;

import java.io.Serializable;

/**
 * A DTO for the {@link ContactAddress} entity
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactAddressDto implements Serializable {
    private Integer id;
    private String email;
}