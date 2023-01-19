package pl.put.cms.server.services.restaurant;

import pl.put.cms.server.entities.restaurant.MenuPosition;

import java.util.List;

public interface MenuPositionsService {

    public List<MenuPosition> getMenuPositionsShownOnMainPage();

    public List<MenuPosition> getMenuPositionsByCategory(String category);

}
