package pl.put.cms.server.entities.cms.dtos;

import lombok.*;
import pl.put.cms.server.entities.cms.Post;

import java.io.Serializable;

/**
 * A DTO for the {@link Post} entity
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto implements Serializable {
    private Integer id;
    private String title;
    private String text;
    private String img;
}