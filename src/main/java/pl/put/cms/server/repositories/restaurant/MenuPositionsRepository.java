package pl.put.cms.server.repositories.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.put.cms.server.entities.restaurant.MenuPosition;

import java.util.List;

@Repository
public interface MenuPositionsRepository extends JpaRepository<MenuPosition, Integer> {

    List<MenuPosition> getMenuPositionsByCategoryAndRestaurant_Id(String category, int restaurantId);

    List<MenuPosition> getMenuPositionsByIsShownOnMainPageIsTrueAndRestaurant_Id(int restaurantId);

}
