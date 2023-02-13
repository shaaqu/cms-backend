package pl.put.cms.server.entities.restaurant;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "menu_positions")
public class MenuPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    @OneToMany(mappedBy = "menuPosition")
    private List<MenuPositionPicture> pictures;

    public MenuPosition() {
    }

}
