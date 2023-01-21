package pl.put.cms.server.repositories.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.cms.server.entities.restaurant.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
