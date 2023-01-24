package pl.put.cms.server.services.cms;

import pl.put.cms.server.entities.cms.dtos.NavigationBarButtonDto;

import java.util.List;

public interface NavigationBarService {

    public List<NavigationBarButtonDto> getNavigationBarButtons(int cmsId);

}
