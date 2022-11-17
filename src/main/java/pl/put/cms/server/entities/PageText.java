package pl.put.cms.server.entities;

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

    @Column(unique = true)
    private String identity;

    @ManyToOne
    private Page page;

    public PageText() {
    }

}
