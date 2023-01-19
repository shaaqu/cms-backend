package pl.put.cms.server.entities.restaurant;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "menu_pictures")
public class ManuPositionPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "menu_position_id")
    private MenuPosition menuPosition;

    public ManuPositionPicture() {
    }

}
