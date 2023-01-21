package pl.put.cms.server.services.restaurant.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.put.cms.server.entities.restaurant.dtos.RestaurantDto;
import pl.put.cms.server.repositories.restaurant.RestaurantRepository;
import pl.put.cms.server.services.restaurant.RestaurantInfoService;

@Service
public class RestaurantInfoServiceImpl implements RestaurantInfoService {

    private final RestaurantRepository restaurantRepository;
    private final ModelMapper modelMapper;

    public RestaurantInfoServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
        this.modelMapper = new ModelMapper();
    }


    @Override
    public RestaurantDto getRestaurantInfo(int id) {
        return modelMapper.map(restaurantRepository.findById(id), RestaurantDto.class);
    }
}
