package pl.put.cms.server.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.cms.server.entities.cms.dtos.ReservationDto;
import pl.put.cms.server.entities.restaurant.dtos.LocationDto;
import pl.put.cms.server.entities.restaurant.dtos.RestaurantDto;
import pl.put.cms.server.services.cms.EmailService;
import pl.put.cms.server.services.restaurant.RestaurantInfoService;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController @RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantInfoService restaurantInfoService;
    private final EmailService emailService;

    @Autowired
    public RestaurantController(RestaurantInfoService restaurantInfoService, EmailService emailService) {
        this.restaurantInfoService = restaurantInfoService;
        this.emailService = emailService;
    }

    @GetMapping("/info/{restaurantId}")
    public RestaurantDto getRestaurantInfo(@PathVariable int restaurantId) {
        return restaurantInfoService.getRestaurantInfo(restaurantId);
    }

    @GetMapping("/info/location/{restaurantId}")
    public List<LocationDto> getRestaurantLocations(@PathVariable int restaurantId) {
        return restaurantInfoService.getRestaurantLocations(restaurantId);
    }

    @GetMapping("/reservation")
    public String makeReservation() {
        ReservationDto reservationDto = new ReservationDto(new Date(System.currentTimeMillis()), 1.5, 1, "Pawel", "mail@mail.com", "123456789", "Pliska");
        emailService.sendEmail(reservationDto);
        return "Reservation";
    }


}
