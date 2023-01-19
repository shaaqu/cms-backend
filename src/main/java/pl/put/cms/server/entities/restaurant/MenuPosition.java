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

    @Column(name = "category")
    private String category;

    @Column(name = "is_shown_on_main_page")
    private boolean isShownOnMainPage;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "menuPosition")
    private List<ManuPositionPicture> pictures;

    public MenuPosition() {
    }

}
