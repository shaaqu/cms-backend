package pl.put.cms.server.repositories.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.cms.server.entities.restaurant.MenuPosition;

import java.util.List;

public interface MenuPositionsRepository extends JpaRepository<MenuPosition, Integer> {

    List<MenuPosition> getMenuPositionsByCategoryAndRestaurant_Id(String category, int restaurantId);

    List<MenuPosition> getMenuPositionsByShownOnMainPageIsTrueAndRestaurant_Id(int restaurantId);

}
