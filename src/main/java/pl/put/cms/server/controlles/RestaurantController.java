package pl.put.cms.server.controlles;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.cms.server.entities.cms.dtos.ReservationDto;
import pl.put.cms.server.entities.restaurant.dtos.LocationDto;
import pl.put.cms.server.entities.restaurant.dtos.RestaurantDto;
import pl.put.cms.server.services.cms.EmailService;
import pl.put.cms.server.services.restaurant.RestaurantInfoService;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/restaurant")
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

    @PostMapping("/reservation")
    public ResponseEntity<ReservationDto> makeReservation(@RequestBody ReservationDto reservationDto) throws MessagingException {
        emailService.sendEmail(reservationDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
