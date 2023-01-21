package pl.put.cms.server.services.restaurant;

import pl.put.cms.server.entities.restaurant.dtos.RestaurantDto;

public interface RestaurantInfoService {

    public RestaurantDto getRestaurantInfo(int id);

}
