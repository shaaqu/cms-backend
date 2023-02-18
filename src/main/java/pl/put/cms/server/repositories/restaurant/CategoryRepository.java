package pl.put.cms.server.repositories.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.cms.server.entities.restaurant.Category;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findAllByRestaurant_Id(int restaurantId);
}
