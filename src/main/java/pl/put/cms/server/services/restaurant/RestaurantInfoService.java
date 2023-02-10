package pl.put.cms.server.services.restaurant;

import pl.put.cms.server.entities.restaurant.dtos.LocationDto;
import pl.put.cms.server.entities.restaurant.dtos.RestaurantDto;

import java.util.List;

public interface RestaurantInfoService {

    RestaurantDto getRestaurantInfo(int id);

    List<LocationDto> getRestaurantLocations(int restaurantId);
}
