package pl.put.cms.server.entities.cms;

import lombok.*;

import javax.persistence.*;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "navigation_bar_buttons")
public class NavigationBarButton {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "url", nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "navigation_bar_id")
    private NavigationBar navigationBar;

}
