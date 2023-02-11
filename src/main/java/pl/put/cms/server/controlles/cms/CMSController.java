package pl.put.cms.server.controlles.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.cms.server.entities.cms.dtos.NavigationBarButtonDto;
import pl.put.cms.server.services.cms.NavigationBarService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cms")
public class CMSController {

    private final NavigationBarService navigationBarService;

    @Autowired
    public CMSController(NavigationBarService navigationBarService) {
        this.navigationBarService = navigationBarService;
    }

    @GetMapping("/navi-bar/{cmsId}")
    List<NavigationBarButtonDto> getNaviBar(@PathVariable int cmsId) {
        return navigationBarService.getNavigationBarButtons(cmsId);
    }

}
