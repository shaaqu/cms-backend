package pl.put.cms.server.services.cms;

import pl.put.cms.server.entities.cms.dtos.NavigationBarDto;

import java.util.List;

public interface NavigationBarService {

    NavigationBarDto getNavigationBar(int cmsId);

}
