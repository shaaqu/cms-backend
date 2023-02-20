package pl.put.cms.server.entities.cms;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "slider_images")
public class SliderImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String text;

    @Column @Lob
    private String image;

    @ManyToOne
    @JoinColumn(name = "cms_id")
    private CMS cms;

}
