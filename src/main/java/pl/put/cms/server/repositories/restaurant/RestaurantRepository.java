package pl.put.cms.server.repositories.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.put.cms.server.entities.restaurant.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
