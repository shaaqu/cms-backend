package pl.put.cms.server.repositories.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.cms.server.entities.restaurant.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
