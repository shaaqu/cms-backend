package pl.put.cms.server.repositories.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.cms.server.entities.restaurant.MenuPosition;

import java.util.List;

public interface MenuPositionsRepository extends JpaRepository<MenuPosition, Integer> {

    List<MenuPosition> getMenuPositionsByCategory(String category);

    List<MenuPosition> getMenuPositionsByShownOnMainPageIsTrue();

}
