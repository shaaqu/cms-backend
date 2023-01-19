package pl.put.cms.server.entities.cms;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "pages_texts")
public class PageText {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    @Column
    private String content;

    @Column
    private String identity;

    @ManyToOne
    private Page page;

    public PageText() {
    }

}
