package pl.put.cms.server.repositories.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.cms.server.entities.restaurant.RestaurantLocation;

import java.util.List;

public interface RestaurantLocationRepository extends JpaRepository<RestaurantLocation, Integer> {

    List<RestaurantLocation> findAllByRestaurant_Id(int restaurantId);

}
