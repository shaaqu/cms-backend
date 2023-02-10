package pl.put.cms.server.controlles.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.cms.server.entities.restaurant.dtos.LocationDto;
import pl.put.cms.server.entities.restaurant.dtos.RestaurantDto;
import pl.put.cms.server.services.restaurant.RestaurantInfoService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController @RequestMapping("/restaurant")
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

    @GetMapping("/info/location/{restaurantId}")
    public List<LocationDto> getRestaurantLocations(@PathVariable int restaurantId) {
        return restaurantInfoService.getRestaurantLocations(restaurantId);
    }


}
