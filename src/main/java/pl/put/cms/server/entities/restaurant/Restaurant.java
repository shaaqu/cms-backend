package pl.put.cms.server.entities.restaurant;

import lombok.Getter;
import lombok.Setter;
import pl.put.cms.server.entities.restaurant.ContactAddress;
import pl.put.cms.server.entities.restaurant.MenuPosition;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "cuisine")
    private String cuisine;

    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantLocation> locations;

    @OneToMany(mappedBy = "restaurant")
    private List<Category> categories;

    @OneToMany(mappedBy = "restaurant")
    private List<ContactAddress> contactAddressList;

    public Restaurant() {
    }

}
