package pl.put.cms.server.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.put.cms.server.entities.restaurant.dtos.MenuPositionDto;
import pl.put.cms.server.entities.restaurant.dtos.MenuPositionPictureDto;
import pl.put.cms.server.services.restaurant.MenuPositionPictureService;
import pl.put.cms.server.services.restaurant.MenuPositionsService;

import java.util.List;

@RestController("/menu")
public class MenuPositionsController {

    private final MenuPositionsService menuPositionsService;
    private final MenuPositionPictureService menuPositionPictureService;

    @Autowired
    public MenuPositionsController(MenuPositionsService menuPositionsService, MenuPositionPictureService menuPositionPictureService) {
        this.menuPositionsService = menuPositionsService;
        this.menuPositionPictureService = menuPositionPictureService;
    }

    @GetMapping("/{restaurantId}/category/{category}")
    public List<MenuPositionDto> getMenuPositionsByCategory(@PathVariable int restaurantId, @PathVariable String category) {
        return menuPositionsService.getMenuPositionsByCategory(category, restaurantId);
    }

    @GetMapping("/picture/{menuPositionId}")
    public MenuPositionPictureDto getMenuPositionsByCategory(@PathVariable int menuPositionId) {
        return menuPositionPictureService.getPicture(menuPositionId);
    }

}