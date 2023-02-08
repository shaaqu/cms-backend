package pl.put.cms.server.services.restaurant.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.put.cms.server.entities.restaurant.MenuPosition;
import pl.put.cms.server.entities.restaurant.dtos.MenuPositionDto;
import pl.put.cms.server.repositories.restaurant.MenuPositionsRepository;
import pl.put.cms.server.services.restaurant.MenuPositionsService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuPositionsServiceImpl implements MenuPositionsService {

    private final MenuPositionsRepository menuPositionsRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MenuPositionsServiceImpl(MenuPositionsRepository menuPositionsRepository) {
        this.menuPositionsRepository = menuPositionsRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<MenuPositionDto> getMenuPositionsShownOnMainPage(int restaurantId) {
        return menuPositionsRepository.getMenuPositionsByIsShownOnMainPageIsTrueAndRestaurant_Id(restaurantId)
                .stream().map(this::mapMenuPositionToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MenuPositionDto> getMenuPositionsByCategory(String category, int restaurantId) {
        return menuPositionsRepository.getMenuPositionsByCategoryAndRestaurant_Id(category, restaurantId)
                .stream().map(this::mapMenuPositionToDto)
                .collect(Collectors.toList());
    }

    private MenuPositionDto mapMenuPositionToDto(MenuPosition menuPosition) {
        return modelMapper.map(menuPosition, MenuPositionDto.class);
    }
}
