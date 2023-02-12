package pl.put.cms.server.entities.cms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "slider_images")
public class SliderImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String text;

    @Column
    private String image;

    @ManyToOne
    @JoinColumn(name = "cms_id")
    private CMS cms;

}
