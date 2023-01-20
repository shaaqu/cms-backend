package pl.put.cms.server.services.restaurant;

import pl.put.cms.server.entities.restaurant.dtos.MenuPositionDto;

import java.util.List;

public interface MenuPositionsService {

    public List<MenuPositionDto> getMenuPositionsShownOnMainPage(int restaurantId);

    public List<MenuPositionDto> getMenuPositionsByCategory(String category, int restaurantId);

}
