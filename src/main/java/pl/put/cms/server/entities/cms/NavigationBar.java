package pl.put.cms.server.entities.cms;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class NavigationBar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "logo")
    @Lob
    private String logo;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "navigationBar")
    private CMS cms;

    @OneToMany(mappedBy = "navigationBar")
    private List<NavigationBarButton> navigationBarButtons;


}
