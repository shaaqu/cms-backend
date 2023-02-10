package pl.put.cms.server.services.restaurant.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.put.cms.server.entities.restaurant.RestaurantLocation;
import pl.put.cms.server.entities.restaurant.dtos.LocationDto;
import pl.put.cms.server.entities.restaurant.dtos.RestaurantDto;
import pl.put.cms.server.repositories.restaurant.RestaurantLocationRepository;
import pl.put.cms.server.repositories.restaurant.RestaurantRepository;
import pl.put.cms.server.services.restaurant.RestaurantInfoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantInfoServiceImpl implements RestaurantInfoService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantLocationRepository restaurantLocationRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RestaurantInfoServiceImpl(RestaurantRepository restaurantRepository, RestaurantLocationRepository restaurantLocationRepository) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantLocationRepository = restaurantLocationRepository;
        this.modelMapper = new ModelMapper();
    }


    @Override
    public RestaurantDto getRestaurantInfo(int id) {
        return modelMapper.map(restaurantRepository.findById(id), RestaurantDto.class);
    }

    @Override
    public List<LocationDto> getRestaurantLocations(int restaurantId) {
        return restaurantLocationRepository.findAllByRestaurant_Id(restaurantId)
                .stream().map(this::mapRestaurantLocationToDto)
                .collect(Collectors.toList());
    }

    private LocationDto mapRestaurantLocationToDto(RestaurantLocation restaurantLocation) {
        return modelMapper.map(restaurantLocation, LocationDto.class);
    }
}
