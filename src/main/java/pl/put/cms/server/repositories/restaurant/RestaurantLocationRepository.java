package pl.put.cms.server.repositories.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.put.cms.server.entities.restaurant.RestaurantLocation;

import java.util.List;
@Repository
public interface RestaurantLocationRepository extends JpaRepository<RestaurantLocation, Integer> {

    List<RestaurantLocation> findAllByRestaurant_Id(int restaurantId);

}
