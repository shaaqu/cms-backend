package pl.put.cms.server.entities.cms;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    @Lob
    private String text;

    @Column(name = "image")
    @Lob
    private String img;

    @ManyToOne
    @JoinColumn(name = "cms_id")
    private CMS cms;

}
