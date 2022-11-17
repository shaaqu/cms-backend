package pl.put.cms.server.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "address")
    private String address;

    @Column(name = "open_close_hours")
    private String openCloseHours;

    @OneToMany(mappedBy = "restaurant")
    private List<MenuPosition> menu;

    @OneToMany(mappedBy = "restaurant")
    private List<ContactAddress> contactAddressList;

    public Restaurant() {
    }

}
