package pl.put.cms.server.entities.cms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.put.cms.server.entities.restaurant.Restaurant;

import javax.persistence.*;
import java.util.List;

@Setter @Getter
@NoArgsConstructor
@Entity
@Table(name = "cms")
public class CMS {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "cms")
    private List<NavigationBarButton> navigationBarButtons;

    @OneToMany(mappedBy = "cms")
    private List<SliderImage> sliderImages;

}
