package pl.put.cms.server.services.restaurant;

import pl.put.cms.server.entities.restaurant.dtos.CategoryDto;
import pl.put.cms.server.entities.restaurant.dtos.MenuPositionDto;

import java.util.List;

public interface MenuService {

    List<MenuPositionDto> getMenuPositionsByCategory(int categoryId);

    List<CategoryDto> getCategories(int restaurantId);

}
