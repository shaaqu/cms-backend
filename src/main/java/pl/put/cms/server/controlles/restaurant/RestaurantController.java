package pl.put.cms.server.controlles.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.put.cms.server.entities.restaurant.dtos.RestaurantDto;
import pl.put.cms.server.services.restaurant.RestaurantInfoService;

@RestController("/restaurant")
public class RestaurantController {

    private final RestaurantInfoService restaurantInfoService;

    @Autowired
    public RestaurantController(RestaurantInfoService restaurantInfoService) {
        this.restaurantInfoService = restaurantInfoService;
    }

    @GetMapping("/info/{restaurantId}")
    public RestaurantDto getRestaurantInfo(@PathVariable int restaurantId) {
        return restaurantInfoService.getRestaurantInfo(restaurantId);
    }


}
