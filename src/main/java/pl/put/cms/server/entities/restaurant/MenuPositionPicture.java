package pl.put.cms.server.entities.restaurant;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu_pictures")
public class MenuPositionPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "menu_position_id")
    private MenuPosition menuPosition;

}
