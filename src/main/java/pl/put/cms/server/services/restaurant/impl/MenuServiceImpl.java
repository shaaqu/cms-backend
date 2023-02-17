package pl.put.cms.server.services.restaurant.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.put.cms.server.entities.restaurant.Category;
import pl.put.cms.server.entities.restaurant.MenuPosition;
import pl.put.cms.server.entities.restaurant.dtos.CategoryDto;
import pl.put.cms.server.entities.restaurant.dtos.MenuPositionDto;
import pl.put.cms.server.repositories.restaurant.CategoryRepository;
import pl.put.cms.server.repositories.restaurant.MenuPositionsRepository;
import pl.put.cms.server.services.restaurant.MenuService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuPositionsRepository menuPositionsRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MenuServiceImpl(MenuPositionsRepository menuPositionsRepository, CategoryRepository categoryRepository) {
        this.menuPositionsRepository = menuPositionsRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<MenuPositionDto> getMenuPositionsByCategory(int categoryId) {
        return menuPositionsRepository.findAllByCategory_Id(categoryId)
                .stream().map(this::mapMenuPositionToDto)
                .collect(Collectors.toList());
    }

    private MenuPositionDto mapMenuPositionToDto(MenuPosition menuPosition) {
        return modelMapper.map(menuPosition, MenuPositionDto.class);
    }

    @Override
    public List<CategoryDto> getCategories(int restaurantId) {
        return categoryRepository.findAllByRestaurant_Id(restaurantId)
                .stream().map(this::mapCategoryToDto)
                .collect(Collectors.toList());
    }

    private CategoryDto mapCategoryToDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }
}
