package pl.put.cms.server.entities.restaurant;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column
    private String mail;

    @Column
    private Date date;
    @Column
    private String name;
    @Column
    private String phoneNumber;
    @Column
    private int numberOfGuests;
    @Column
    private String massage;

}
