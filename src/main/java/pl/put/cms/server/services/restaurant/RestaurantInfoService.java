package pl.put.cms.server.services.restaurant;

import pl.put.cms.server.entities.restaurant.dtos.RestaurantDto;
import pl.put.cms.server.entities.restaurant.dtos.RestaurantLocationDto;

import java.util.List;

public interface RestaurantInfoService {

    RestaurantDto getRestaurantInfo(int id);

    List<RestaurantLocationDto> getRestaurantLocations(int restaurantId);
}
