package pl.put.cms.server.entities.cms;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder @AllArgsConstructor
@NoArgsConstructor
@Table(name = "administrators")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private char[] password;

}
