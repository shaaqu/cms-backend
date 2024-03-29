package pl.put.cms.server.entities.cms;

import lombok.*;
import pl.put.cms.server.entities.restaurant.Restaurant;

import javax.persistence.*;
import java.util.List;

@Setter @Getter
@NoArgsConstructor
@Builder @AllArgsConstructor
@Entity
@Table(name = "cms")
public class CMS {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "admin_id")
    private Administrator administrator;

    @OneToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToOne
    @JoinColumn(name = "navigation_bar_id")
    private NavigationBar navigationBar;

    @OneToMany(mappedBy = "cms")
    private List<SliderImage> sliderImages;

    @OneToMany(mappedBy = "cms")
    private List<Post> posts;

}
