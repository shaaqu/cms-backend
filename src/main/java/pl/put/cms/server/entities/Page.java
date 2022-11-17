package pl.put.cms.server.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pages")
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String title;

    @Column(unique = true)
    private String url;

    @OneToMany(mappedBy = "page")
    @ToString.Exclude
    private List<PageText> pageTexts = new ArrayList<>();

    @OneToMany(mappedBy = "page")
    @ToString.Exclude
    private List<PageImage> pageImages = new ArrayList<>();

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="parent_page_id")
    private Page parentPage;

    @OneToMany(mappedBy = "parentPage")
    @ToString.Exclude
    private List<Page> subPages;

    public Page() {
    }

}