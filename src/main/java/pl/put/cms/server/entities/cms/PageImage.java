package pl.put.cms.server.entities.cms;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "pages_images")
public class PageImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Page page;

    @Column
    private String image;

    @Column
    private String identity;

    @Column
    private String path;

    public PageImage() {
    }
}
