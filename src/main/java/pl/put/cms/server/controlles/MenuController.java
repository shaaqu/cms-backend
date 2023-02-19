package pl.put.cms.server.controlles;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.cms.server.entities.restaurant.dtos.CategoryDto;
import pl.put.cms.server.entities.restaurant.dtos.MenuPositionDto;
import pl.put.cms.server.entities.restaurant.dtos.MenuPositionPictureDto;
import pl.put.cms.server.services.restaurant.MenuPositionPictureService;
import pl.put.cms.server.services.restaurant.MenuService;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;
    private final MenuPositionPictureService menuPositionPictureService;

    @Autowired
    public MenuController(MenuService menuService, MenuPositionPictureService menuPositionPictureService) {
        this.menuService = menuService;
        this.menuPositionPictureService = menuPositionPictureService;
    }

    @GetMapping("/category/{categoryId}")
    public List<MenuPositionDto> getMenuPositionsByCategory(@PathVariable int categoryId) {
        log.info("Getting menu pos.");
        return menuService.getMenuPositionsByCategory(categoryId);
    }

    @GetMapping("/{menuPositionId}/picture")
    public MenuPositionPictureDto getMenuPositionPicture(@PathVariable int menuPositionId) {
        log.info("Getting pics");
        return menuPositionPictureService.getPicture(menuPositionId);
    }

    @GetMapping("/categories/{restaurantId}")
    public List<CategoryDto> getCategories(@PathVariable int restaurantId) {
        log.info("getting categoreis");
        return menuService.getCategories(restaurantId);
    }

}